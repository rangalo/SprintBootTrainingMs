package net.autorisiert.eventservice.model;

import org.springframework.data.annotation.Id;

public class Event {
    @Id private String id;
    private String name;
    private int ticketsBooked;
    private int ticketCount;
    private String description;

    public Event() {

    }

    public Event(String id, String name, String description, int ticketCount) {
        this.id = id;
        this.name = name;
        this.ticketCount = ticketCount;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTicketsBooked() {
        return ticketsBooked;
    }

    public void setTicketsBooked(int ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
