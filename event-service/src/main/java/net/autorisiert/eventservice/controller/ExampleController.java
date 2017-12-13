package net.autorisiert.eventservice.controller;

import net.autorisiert.eventservice.model.Event;
import net.autorisiert.eventservice.model.Example;
import net.autorisiert.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ExampleController {

    private final EventRepository eventRepository;

    private RepositoryRestMvcConfiguration configuration;

    @Autowired
    public ExampleController(EventRepository eventRepository, RepositoryRestMvcConfiguration configuration) {
        this.eventRepository = eventRepository;
        this.configuration = configuration;
    }

    @RequestMapping("/examples/{id}")
    public Example getExample(@PathVariable("id") int id){
        Example ex = new Example(id);
        ex.add(linkTo(methodOn(ExampleController.class).getExample(id)).withSelfRel());
        return ex;
    }

    @RequestMapping(value = "/examples", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    public Resources<Example> listExamples(){
        Example ex1 = new Example(1);
        ex1.add(linkTo(methodOn(ExampleController.class).getExample(1)).withSelfRel());
        Example ex2 = new Example(2);
        ex2.add(linkTo(methodOn(ExampleController.class).getExample(2)).withSelfRel());
        List<Example> list = new ArrayList<>();
        list.add(ex1);
        list.add(ex2);
        Resources<Example> resources = new Resources<>(list);
        resources.add(linkTo(methodOn(ExampleController.class).listExamples()).withSelfRel());
        return resources;
    }

    @RequestMapping("/customEvents")
    public Collection<Resource<Event>> customEvents(){
        List<Event> events = eventRepository.findAll();
        List<Resource<Event>> list = new ArrayList<>();
        for(Event e : events){
            list.add(getResource(e));
        }
        return list;
    }

    private Resource<Event> getResource(Event e) {
        Resource<Event> res = new Resource<>(e);
        LinkBuilder link = configuration.entityLinks().linkForSingleResource(Event.class,
                e.getId());
        res.add(link.withSelfRel());
        return res;
    }
}

