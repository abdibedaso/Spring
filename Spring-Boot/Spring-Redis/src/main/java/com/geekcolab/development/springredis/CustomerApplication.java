package com.geekcolab.development.springredis;

import com.geekcolab.development.springredis.domain.CreditCard;
import com.geekcolab.development.springredis.domain.Customer;
import com.geekcolab.development.springredis.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // create customer
        Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
        CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
        customer.setCreditCard(creditCard);
        customerRepository.save(customer);

        customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
        creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
        customer.setCreditCard(creditCard);
        customerRepository.save(customer);

//        get customers
        System.out.println(customerRepository.findById(66).get());
        System.out.println(customerRepository.findById(101).get());
        System.out.println("-----------All customers ----------------");
        System.out.println(customerRepository.findAll());

        //update customer
        customer = customerRepository.findById(101).get();
        customer.setEmail("jd@gmail.com");
        customerRepository.save(customer);

        //delete customer
        customerRepository.deleteById(66);
        System.out.println("-----------All customers ----------------");
        System.out.println(customerRepository.findAll());

        customerRepository.deleteAll();

    }
}
