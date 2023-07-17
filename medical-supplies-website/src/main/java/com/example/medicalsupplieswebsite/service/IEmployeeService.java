package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee>{
    /**
     * this function could return a list of employee ,that can display all employee or combines search with 3 params
     * @param name
     * @param date
     * @param position
     * @return list of employee
     */
    List<Employee> findAllEmWithNameAndDateAndPositions(String name,String date,String position);
    /**
     * this function could return 1 employee of employee table by id employee
     * @param id
     * @return employee
     */
    void deleteEmployee(Long id);

    /**
     * this function could delete employee by id employee
     * @param id
     * @return none
     */
    Employee findEmployeeByID(Long id);
}
