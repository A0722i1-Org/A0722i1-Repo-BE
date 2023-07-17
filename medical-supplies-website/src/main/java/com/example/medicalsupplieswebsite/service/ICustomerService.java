package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Customer;

public interface ICustomerService extends IService<Customer>{
    public Customer findByUsername(String username);
}
