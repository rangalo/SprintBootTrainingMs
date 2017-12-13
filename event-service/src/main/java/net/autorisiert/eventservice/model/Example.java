package net.autorisiert.eventservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Example extends ResourceSupport {

    private final int exampleId;

    @JsonCreator
    public Example(@JsonProperty("exampleId") int id) {
        this.exampleId = id;
    }

    public int getExampleId() {
        return exampleId;
    }
}
