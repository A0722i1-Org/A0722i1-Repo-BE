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

    @Override
    public List<Employee> findAllEmWithNameAndDateAndPositions(String name, String date, String position) {
        return iEmployeeRepository.findAllByNameAndDobAndAndPosition(name,date,position);
    }

    @Override
    public void deleteEmployee(Long id) {
        iEmployeeRepository.deleteEmployeeByID(id);
    }

    @Override
    public Employee findEmployeeByID(Long id) {
        return iEmployeeRepository.getEmployeeById(id);
    }
}
