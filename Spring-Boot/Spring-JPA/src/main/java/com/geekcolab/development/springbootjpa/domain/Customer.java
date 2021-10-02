package com.geekcolab.development.springbootjpa.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    private int customerNumber;
    private String name;
    private String email;
    private String phone;
    @ManyToOne(cascade = CascadeType.ALL)

    private CreditCard creditCard;

    public Customer(int i, String name, String email, String phone) {
        this.customerNumber = i;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customer() {

    }
}
