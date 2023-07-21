package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.EmployeeInfo;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.repository.IEmployeeRepository;
import com.example.medicalsupplieswebsite.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     *
     * @param employeeInfo
     */
    @Override
    public void save(EmployeeInfo employeeInfo) {

        Employee employee = new Employee(null, employeeInfo.getEmployeeCode(), employeeInfo.getEmployeeName(),
                employeeInfo.getEmail(), employeeInfo.getPhone(), employeeInfo.getEmployeeAddress(), employeeInfo.getGender(),
                employeeInfo.getIdCard(), employeeInfo.getDateOfBirth(), employeeInfo.getEmployeeImg(), false,
                employeeInfo.getPosition());
        iEmployeeRepository.save(employee);
    }

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param id
     * @return Employee was found by id
     */
    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findAllById(id);
    }

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     *
     * @param employeeInfo
     * @param id
     */
    @Override
    public void updateEmployee(EmployeeInfo employeeInfo, Long id) {
        iEmployeeRepository.updateEmployee(employeeInfo.getEmployeeName(), employeeInfo.getEmail(), employeeInfo.getPhone(),
                employeeInfo.getEmployeeAddress(), employeeInfo.getGender(), employeeInfo.getIdCard(), employeeInfo.getDateOfBirth(),
                employeeInfo.getEmployeeImg(), employeeInfo.getPosition(), id);
    }

    /**
     * Created by PhongTD
     * Date created: 21/07/2023
     * @return List all employee
     */
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
