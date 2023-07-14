package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.EmployeeInfo;
import com.example.medicalsupplieswebsite.dto.InvalidDataException;
import com.example.medicalsupplieswebsite.dto.ValidationError;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param employeeInfo
     * @param bindingResult
     * @return if info of employee valid return httpStatus.CREATED else return error
     */
    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeInfo employeeInfo, BindingResult bindingResult) {
        new EmployeeInfo().validate(employeeInfo, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    error -> {
                        String fieldName = error.getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                    });
            return ResponseEntity.badRequest().body(errors);
        } else {
            iEmployeeService.save(employeeInfo);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return iEmployeeService.findById(id);
    }

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param id
     * @param employeeInfo
     * @param bindingResult
     * @return if info of employee valid return httpStatus.OK else return error
     */
    @PutMapping("{id}")
    public ResponseEntity<?> updateEmployee(@Valid @PathVariable Long id, @RequestBody EmployeeInfo employeeInfo, BindingResult bindingResult) {
        new EmployeeInfo().validate(employeeInfo, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    error -> {
                        String fieldName = error.getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                    });
            return ResponseEntity.badRequest().body(errors);
        } else {
            iEmployeeService.updateEmployee(employeeInfo, id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidDataException(InvalidDataException ex) {
        List<ValidationError> errors1 = ex.getErrors();
        Map<String, String> errors = new HashMap<>();
        errors1.forEach((error) -> {

            String fieldName = error.getField();
            String errorMessage = error.getMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.badRequest().body(errors);

    }
}
