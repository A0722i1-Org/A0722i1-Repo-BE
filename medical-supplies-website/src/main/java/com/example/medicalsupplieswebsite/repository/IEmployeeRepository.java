package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT employee FROM Employee employee WHERE employee.employeeId = ?1")
    Employee findAllById(Long id);
}
