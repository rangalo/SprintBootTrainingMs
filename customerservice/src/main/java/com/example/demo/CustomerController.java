package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/creditcard/{id}")
    public String getCreditCard(@PathVariable("id") int id){
        final Customer cust = customerRepository.findOne(id);
        return cust.getCreditcardNo();
    }
}
