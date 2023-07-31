package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.repository.IAccountRepository;
import com.example.medicalsupplieswebsite.repository.IEmployeeRepository;
import com.example.medicalsupplieswebsite.service.IEmployeeService;
import com.example.medicalsupplieswebsite.dto.EmployeeUserDetailDto;
import com.example.medicalsupplieswebsite.dto.EmployeeInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }


    @Override
    public Employee update(Employee employee) {
        return null;
    }

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     *
     * @param employeeInfo
     */
    @Override
    public void save(EmployeeInfo employeeInfo) {
        iAccountRepository.save(employeeInfo.getAccount());
        Account account = iAccountRepository.findByUserName(employeeInfo.getAccount().getUsername());
        Employee employee = new Employee(null, employeeInfo.getEmployeeCode(), employeeInfo.getEmployeeName(),
                employeeInfo.getEmail(), employeeInfo.getPhone(), employeeInfo.getEmployeeAddress(), employeeInfo.getGender(),
                employeeInfo.getIdCard(), employeeInfo.getDateOfBirth(), employeeInfo.getEmployeeImg(), true,
                employeeInfo.getPosition(), account);
        iEmployeeRepository.save(employee);
    }


    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     *
     * @param id
     * @return Employee was found by id
     */
//    @Override
//    public Employee findById(Long id) {
//    return null;
//    }
    @Override
    public Employee findById(Long id) {
return null;
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
     *
     * @return List all employee
     */
//    @Override
//    public List<Employee> findAll() {
//        return iEmployeeRepository.findAll();
//    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Employee findByUsername(String username) {
        return iEmployeeRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    /**
     * A0722I1-KhanhNL
     */
    @Override
    public EmployeeUserDetailDto findUserDetailByUsername(String username) {
        Tuple tuple = iEmployeeRepository.findUserDetailByUsername(username).orElse(null);
        if (tuple != null) {
            return EmployeeUserDetailDto.TupleToEmployeeDto(tuple);
        }
        return null;
    }

    /**
     * this function could return a list of employee ,that can display all employee or combines search with 3 params
     *
     * @param name
     * @param date
     * @param position
     * @return list of employee
     */
    @Override
    public List<Employee> findAllEmWithNameAndDateAndPositions(String name, String date, String position) {
        List<Employee> employeeList = iEmployeeRepository.findAllByNameAndDobAndAndPosition(name, date, position);
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return employee.getEmployeeId() > t1.getEmployeeId() ? 1 : -1;
            }
        });
        return employeeList;

    }

    /**
     * this function could return 1 employee of employee table by id employee
     *
     * @param id
     * @return employee
     */
    @Override
    public void deleteEmployee(Long id) {
        iEmployeeRepository.deleteEmployeeByID(id);
    }

    /**
     * this function could delete employee by id employee
     *
     * @param id
     * @return none
     */
    @Override
    public Employee findEmployeeByID(Long id) {
        return iEmployeeRepository.getEmployeeById(id);
    }

    @Override
    public Employee findEmployeeByUserName(String userName) {
        return iEmployeeRepository.findEmployeeByUserName(userName).orElse(null);
    }


    /*
     * NhanTQ
     */
    @Override
    public void updateEmployeeByFieldsDTO(String employeeName, String employeeImg, boolean gender, Date dateOfBirth, String employeeAddress, String phone, String email, String username) {
        iEmployeeRepository.updateEmployeeDto(employeeName, employeeImg, gender, dateOfBirth, employeeAddress, phone, email, username);
    }

    @Override
    public Optional<Employee> findEmployeeIdByUserName(String userName) {
        return iEmployeeRepository.findEmployeeIdByUserName(userName);
    }
}