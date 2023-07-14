package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.EmployeeInfo;
import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.repository.IEmployeeRepository;
import com.example.medicalsupplieswebsite.service.IEmployeeService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Employee employee = new Employee(employeeInfo.getId(), employeeInfo.getEmployeeCode(), employeeInfo.getName(),
                employeeInfo.getEmail(), employeeInfo.getPhone(), employeeInfo.getAddress(), employeeInfo.getGender(),
                employeeInfo.getIdCard(), employeeInfo.getDateOfBirth(), employeeInfo.getAvatar(), false,
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
        iEmployeeRepository.updateEmployee(employeeInfo.getName(), employeeInfo.getEmail(), employeeInfo.getPhone(),
                employeeInfo.getAddress(), employeeInfo.getGender(), employeeInfo.getIdCard(), employeeInfo.getDateOfBirth(),
                employeeInfo.getAvatar(), employeeInfo.getPosition(), id);
    }
}
