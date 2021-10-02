package com.geekcolab.development.springmongo.repositories;

import com.geekcolab.development.springmongo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
    Customer findByPhone(String phone);
    Customer findByName(String name);
    @Query("{'email' : ?0}")
    Customer findCustomerWithPhone(String email);
    @Query("{'creditCard.type' : ?0}")
    List<Customer> findCustomerWithCreditCardType(String cctype);
}
