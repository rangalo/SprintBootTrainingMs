package net.autorisiert.micro.apigateway.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @RequestMapping("/customers/creditcard")
    String getCreditCard();
}
