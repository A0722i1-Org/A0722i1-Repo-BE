package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.EmployeeInfo;
import com.example.medicalsupplieswebsite.entity.Employee;

public interface IEmployeeService {
    void save(EmployeeInfo employeeInfo);

    Employee findById(Long id);
    void updateEmployee(EmployeeInfo employeeInfo, Long id);
}
