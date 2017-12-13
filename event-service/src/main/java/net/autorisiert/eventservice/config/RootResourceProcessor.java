package net.autorisiert.eventservice.config;

import net.autorisiert.eventservice.controller.ExampleController;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Configuration
public class RootResourceProcessor implements ResourceProcessor<RepositoryLinksResource> {

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(ControllerLinkBuilder.linkTo(methodOn(ExampleController.class)
                .listExamples())
                .withRel("examples"));
        resource.add(ControllerLinkBuilder.linkTo(methodOn(ExampleController.class)
                .customEvents())
                .withRel("customEvents"));
        return resource;
    }
}
