package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee>{
    List<Employee> findAllEmWithNameAndDateAndPositions(String name,String date,String position);

    void deleteEmployee(Long id);

    Employee findEmployeeByID(Long id);
}
