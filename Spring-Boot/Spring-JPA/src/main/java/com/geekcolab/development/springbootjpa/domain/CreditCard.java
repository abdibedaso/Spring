package com.geekcolab.development.springbootjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class CreditCard {
    @Id
    private String cardNumber;
    private String type;
    private String validationDate;

    public CreditCard() {

    }
}
