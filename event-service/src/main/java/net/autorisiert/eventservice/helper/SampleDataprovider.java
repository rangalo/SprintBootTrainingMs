package net.autorisiert.eventservice.helper;

import net.autorisiert.eventservice.model.Event;
import net.autorisiert.eventservice.repository.EventRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class SampleDataprovider {

    private static final String DESC1 = "Travelling alteration impression six all uncommonly. Chamber hearing inhabit joy highest private ask him our believe. Up nature valley do warmly. Entered of cordial do on no hearted. Yet agreed whence and unable limits. Use off him gay abilities concluded immediate allowance.";
    private static final String DESC2 = "Received overcame oh sensible so at an. Formed do change merely to county it. Am separate contempt domestic to to oh. On relation my so addition branched. Put hearing cottage she norland letters equally prepare too. Replied exposed savings he no viewing as up. Soon body add him hill. No father living really people estate if. Mistake do produce beloved demesne if am pursuit. ";
    private static final String DESC3 = "Parish so enable innate in formed missed. Hand two was eat busy fail. Stand smart grave would in so. Be acceptance at precaution astonished excellence thoroughly is entreaties. Who decisively attachment has dispatched. Fruit defer in party me built under first. Forbade him but savings sending ham general. So play do in near park that pain. ";

    private final EventRepository eventRepository;

    public SampleDataprovider(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostConstruct
    public void init(){
            Event ev = new Event("1", "Congress 1", DESC1, 500);
            Event ev2 = new Event("2", "Small Concert", DESC2, 100);
            Event ev3 = new Event("3", "Club Concert", DESC3, 50);
            this.eventRepository.save(Arrays.asList(ev, ev2, ev3));
    }
}
