package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.service.impl.CustomerService;
import com.example.medicalsupplieswebsite.service.impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    @ModelAttribute("customertypes")
//    public Iterable<CustomerType> customerTypes() {
//        return customerTypeService.findAllCustomerType();
//    }

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

