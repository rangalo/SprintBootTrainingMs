package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class SampleDataProvider {


    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger =
            LoggerFactory.getLogger(CustomerRepository.class);

    public SampleDataProvider() {
    }


    @PostConstruct
    public void init(){
        try {
            Customer c = new Customer();
            c.setCreditcardNo("xxx-yyy");
            c.setName("Customer 1");
            customerRepository.save(c);
        }catch(Exception ex){
            logger.error("init", ex);
        }
    }
}
