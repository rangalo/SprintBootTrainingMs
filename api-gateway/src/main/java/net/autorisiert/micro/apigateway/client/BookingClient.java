package net.autorisiert.micro.apigateway.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "booking-service")
public interface BookingClient {
    @RequestMapping("/booking/{id}")
    String DoBooking(@PathVariable("id") String eventId);
}
