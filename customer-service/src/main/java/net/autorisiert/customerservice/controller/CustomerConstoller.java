package net.autorisiert.customerservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerConstoller {

    private static final Logger log = LoggerFactory.getLogger(CustomerConstoller.class);

    @GetMapping("/creditcard")
    public String getCreditCard() {

        return "123456789";
    }

}
