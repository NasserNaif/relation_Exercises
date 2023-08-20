package com.example.day1relations.Repos;

import com.example.day1relations.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
}
