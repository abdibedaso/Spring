package com.geekcolab.development.springmongo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Customer {
    @Id
    private int customerNumber;
    private String name;
    private String email;
    private String phone;
    private CreditCard creditCard;

    public Customer(int i, String name, String email, String phone) {
        this.customerNumber = i;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
