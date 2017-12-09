package net.autorisiert.eventservice.repository;

import net.autorisiert.eventservice.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findByName(@Param("name") String name);

}
