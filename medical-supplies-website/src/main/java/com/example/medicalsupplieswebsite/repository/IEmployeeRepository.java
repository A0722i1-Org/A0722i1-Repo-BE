package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
