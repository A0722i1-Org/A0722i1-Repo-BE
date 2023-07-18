package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.entity.Customer;

public interface ICustomerService extends IService<Customer>{
    Customer findByUsername(String username);

    CustomerUserDetailDto findUserDetailByUsername(String username);
}
