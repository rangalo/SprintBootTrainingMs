package net.autorisiert.micro.apigateway.controller;

import net.autorisiert.micro.apigateway.client.BookingClient;
import net.autorisiert.micro.apigateway.client.CustomerClient;
import net.autorisiert.micro.apigateway.model.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final BookingClient bookingClient;

    private final CustomerClient customerClient;

    @Autowired
    public EventController(BookingClient bookingClient, CustomerClient customerClient) {
        this.bookingClient = bookingClient;
        this.customerClient = customerClient;
    }

    @RequestMapping("/book/{id}")
    public String bookEvent(@PathVariable("id") String id){

        String bookingId = bookingClient.DoBooking(id);
        String cc = customerClient.getCreditCard();
        return bookingId + "  CreditCard=" + cc;
    }

}
