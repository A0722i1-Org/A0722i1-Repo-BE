package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
