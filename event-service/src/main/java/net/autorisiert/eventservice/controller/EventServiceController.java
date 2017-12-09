package net.autorisiert.eventservice.controller;

import net.autorisiert.eventservice.model.Event;
import net.autorisiert.eventservice.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EventServiceController {

    private static final Logger log = LoggerFactory.getLogger(EventServiceController.class);

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/allocateTicket")
    public String allocateTicket(@RequestBody String eventId){
        log.info("allocate ticket for {}", eventId);
        Event event = eventRepository.findOne(eventId);
        event.setTicketsBooked(event.getTicketsBooked() + 1);
        eventRepository.save(event);
        return UUID.randomUUID().toString();
    }
}
