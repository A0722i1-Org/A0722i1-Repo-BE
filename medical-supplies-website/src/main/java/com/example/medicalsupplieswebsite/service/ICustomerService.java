package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Customer;

public interface ICustomerService extends IService<Customer>{
    Customer findByUsername(String username);
    String findAddressByCustomerId(Long customerId );
}
