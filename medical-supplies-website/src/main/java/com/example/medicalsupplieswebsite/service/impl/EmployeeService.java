package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.EmployeeUserDetailDto;
import com.example.medicalsupplieswebsite.dto.EmployeeInfo;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.repository.IEmployeeRepository;
import com.example.medicalsupplieswebsite.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;

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
        return iEmployeeRepository.findAllById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public void save(EmployeeInfo employeeInfo) {
        Employee employee = new Employee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeCode(), employeeInfo.getEmployeeName(),
                employeeInfo.getEmail(), employeeInfo.getPhone(), employeeInfo.getEmployeeAddress(), employeeInfo.getGender(),
                employeeInfo.getIdCard(), employeeInfo.getDateOfBirth(), employeeInfo.getEmployeeImg(), false,
                employeeInfo.getPosition());
        iEmployeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeInfo employeeInfo, Long id) {
        iEmployeeRepository.updateEmployee(employeeInfo.getEmployeeName(), employeeInfo.getEmail(), employeeInfo.getPhone(),
                employeeInfo.getEmployeeAddress(), employeeInfo.getGender(), employeeInfo.getIdCard(), employeeInfo.getDateOfBirth(),
                employeeInfo.getEmployeeImg(), employeeInfo.getPosition(), id);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Employee findByUsername(String username) {
        return iEmployeeRepository.findByUsername(username).orElse(null);
    }

    @Override
    public EmployeeUserDetailDto findUserDetailByUsername(String username) {
        Tuple tuple = iEmployeeRepository.findUserDetailByUsername(username).orElse(null);
        if (tuple != null) {
            return EmployeeUserDetailDto.TupleToEmployeeDto(tuple);
        }
        return null;
    }
}
