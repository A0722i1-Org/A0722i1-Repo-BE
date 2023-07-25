package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.EmployeeDTO;
import com.example.medicalsupplieswebsite.dto.EmployeeUserDetailDto;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * A0722I1-KhanhNL
     */
    @GetMapping("/detail")
    public ResponseEntity<EmployeeUserDetailDto> getDetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        EmployeeUserDetailDto employeeUserDetailDto = iEmployeeService.findUserDetailByUsername(username);

        if (employeeUserDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeUserDetailDto, HttpStatus.OK);
    }

    /**
     * this function could return a list of employee ,that can display all employee or combines search with 3 params
     *
     * @param name
     * @param date
     * @param pos
     * @return list of employee
     */
    @GetMapping("")
    public ResponseEntity<List<Employee>> findAllEmployees(@RequestParam(defaultValue = "") String name,
                                                           @RequestParam(defaultValue = "") String date,
                                                           @RequestParam(defaultValue = "") String pos) {
        List<Employee> listEmployee = iEmployeeService.findAllEmWithNameAndDateAndPositions(name, date, pos);
        if (listEmployee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }

    /**
     * this function could return 1 employee of employee table by id employee
     *
     * @param id_employee
     * @return employee
     */
    @DeleteMapping("/delete/{id_employee}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id_employee) {
        iEmployeeService.deleteEmployee(id_employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * this function could delete employee by id employee
     *
     * @param id_employee
     * @return none
     */
    @GetMapping("/{id_employee}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id_employee) {
        Employee employee = iEmployeeService.findEmployeeByID(id_employee);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /*
     *NhanTQ
     */
    @PatchMapping("/update-employee")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (iEmployeeService.findByUsername(username) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        iEmployeeService.updateEmployeeByFieldsDTO(employeeDTO.getEmployeeName(), employeeDTO.getEmployeeImg(),
                employeeDTO.isGender(), employeeDTO.getDateOfBirth(), employeeDTO.getEmployeeAddress(),
                employeeDTO.getPhone(), employeeDTO.getEmail(), username);
        return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
    }
    /*
     *NhanTQ
     */
    @GetMapping("/user-detail-update")
    public ResponseEntity<?> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Employee employee = iEmployeeService.findByUsername(username);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
