package net.autorisiert.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookingController {

    private final RestTemplate restTemplate;

    @Autowired
    public BookingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/booking/{id}")
    public String DoBooking(@PathVariable("id") String eventId){
        ResponseEntity<String> response = this.restTemplate
                .postForEntity("http://event-service/allocateTicket", eventId, String.class);

        return response.getBody();
    }
}
