package com.geekcolab.development.springredis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    private String cardNumber;
    private String type;
    private String validationDate;
}
