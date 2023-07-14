package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
