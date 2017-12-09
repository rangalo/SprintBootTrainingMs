package net.autorisiert.micro.apigateway.controller;

import net.autorisiert.micro.apigateway.client.BookingClient;
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

    @Autowired
    public EventController(BookingClient bookingClient) {
        this.bookingClient = bookingClient;
    }

    @RequestMapping("/book/{id}")
    public String bookEvent(@PathVariable("id") String id){
        return bookingClient.DoBooking(id);
    }

}
