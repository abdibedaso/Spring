package com.geekcolab.development.springredis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Customer")
@NoArgsConstructor
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
