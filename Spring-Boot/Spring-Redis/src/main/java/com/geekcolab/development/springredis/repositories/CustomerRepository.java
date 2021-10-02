package com.geekcolab.development.springredis.repositories;

import com.geekcolab.development.springredis.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {}
