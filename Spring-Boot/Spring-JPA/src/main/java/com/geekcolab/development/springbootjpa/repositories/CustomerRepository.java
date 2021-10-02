package com.geekcolab.development.springbootjpa.repositories;

import com.geekcolab.development.springbootjpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByPhone(String phone);
    Customer findByName(String name);
    List<Customer> findByNameOrPhone(String name, String phone);
    @Query("select c from Customer c where c.email= :email")
    Customer findCustomerWithEmail(String email);
    @Query("select c from Customer c where c.creditCard.type= :cctype")
    List<Customer> findCustomerWithCreditCardType(String cctype);
}
