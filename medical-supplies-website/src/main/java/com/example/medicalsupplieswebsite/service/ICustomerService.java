package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.entity.Customer;

import java.util.Optional;

public interface ICustomerService extends IService<Customer>{
    Customer findByUsername(String username);
    CustomerDto findByPhoneCustomer(String phone);
}
