package com.example.demo;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditcardNo() {
        return creditcardNo;
    }

    public void setCreditcardNo(String creditcardNo) {
        this.creditcardNo = creditcardNo;
    }

    private String creditcardNo;
}
