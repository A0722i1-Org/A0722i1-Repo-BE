package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.repository.IEmployeeRepository;
import com.example.medicalsupplieswebsite.service.IEmployeeService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;
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
    /**
     * this function could return a list of employee ,that can display all employee or combines search with 3 params
     * @param name
     * @param date
     * @param position
     * @return list of employee
     */
    @Override
    public List<Employee> findAllEmWithNameAndDateAndPositions(String name, String date, String position) {
        return iEmployeeRepository.findAllByNameAndDobAndAndPosition(name,date,position);
    }
    /**
     * this function could return 1 employee of employee table by id employee
     * @param id
     * @return employee
     */
    @Override
    public void deleteEmployee(Long id) {
        iEmployeeRepository.deleteEmployeeByID(id);
    }
    /**
     * this function could delete employee by id employee
     * @param id
     * @return none
     */
    @Override
    public Employee findEmployeeByID(Long id) {
        return iEmployeeRepository.getEmployeeById(id);
    }
}
