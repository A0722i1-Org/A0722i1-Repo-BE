package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IService<Employee> {


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
