package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.entity.Customer;

public interface ICustomerService extends IService<Customer>{
    Customer findByUsername(String username);

    /**
     * A0722I1-KhanhNL
     */
    CustomerUserDetailDto findUserDetailByUsername(String username);
    String findAddressByCustomerId(Long customerId );
}
