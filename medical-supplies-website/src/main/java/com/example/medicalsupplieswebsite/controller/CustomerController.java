package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.CustomerInfo;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import com.example.medicalsupplieswebsite.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> findAllCustomer(@RequestParam("page") Optional<Integer> page,
                                                          @RequestParam("size") Optional<Integer> size,
                                                          @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(1);
        String sortField = sort.orElse("name");
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortField).descending());
        Page<Customer> customers = this.customerService.findAll(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }

    @Autowired
    private ICustomerService iCustomerService;


    @PostMapping("")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerInfo customerInfo, BindingResult bindingResult) {
        new CustomerInfo().validate(customerInfo,bindingResult);
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
            iCustomerService.saveCustomer(customerInfo);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return iCustomerService.findById(id);
    }



@PutMapping("{id}")
public ResponseEntity<?> updateCustomer(@Valid @PathVariable Long id, @RequestBody CustomerInfo employeeInfo, BindingResult bindingResult) {
    new CustomerInfo().validate(employeeInfo, bindingResult);
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
        iCustomerService.update(employeeInfo, id);

    }
    return new ResponseEntity<>(HttpStatus.OK);
}



    /**
     * A0722I1-KhanhNL
     */
    @GetMapping("/detail")
    public ResponseEntity<CustomerUserDetailDto> getDetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        CustomerUserDetailDto customerUserDetailDto = iCustomerService.findUserDetailByUsername(username);

        if (customerUserDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerUserDetailDto, HttpStatus.OK);
    }
}

    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomer(@RequestParam(required = false) String type,
                                                         @RequestParam(required = false) String name,
                                                         @RequestParam(required = false) String address,
                                                         @RequestParam(required = false) String phone) {
        List<Customer> searchCustomers = customerService.searchCustomers(type, name, address, phone);
        if (searchCustomers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(searchCustomers, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

