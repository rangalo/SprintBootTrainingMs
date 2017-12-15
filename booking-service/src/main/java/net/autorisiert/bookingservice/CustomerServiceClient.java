package net.autorisiert.bookingservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("customer-service")
public interface CustomerServiceClient {
    @RequestMapping("/creditcard/{id}")
    public String creditCard(@PathVariable("id") int id);
}
