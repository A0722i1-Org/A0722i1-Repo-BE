package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import com.example.medicalsupplieswebsite.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customer-type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public ResponseEntity<List<CustomerType>> getAllCustomerType() {
        return new ResponseEntity<>(iCustomerTypeService.findAllCustomerType(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerType> findCustomerTypeById(@PathVariable Long id) {
        CustomerType customerType= iCustomerTypeService.findById(id);
        if (customerType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerType, HttpStatus.OK);
    }



    }
