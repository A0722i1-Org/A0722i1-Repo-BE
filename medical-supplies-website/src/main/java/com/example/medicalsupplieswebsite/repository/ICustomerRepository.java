package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByUsername(String username);
}
