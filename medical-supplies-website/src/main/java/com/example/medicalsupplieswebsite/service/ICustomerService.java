package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer>{
    List<Customer> customerList();
}
