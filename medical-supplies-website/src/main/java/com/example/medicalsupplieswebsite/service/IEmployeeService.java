package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Employee;

public interface IEmployeeService extends IService<Employee>{
    Employee findByUsername(String username);
}
