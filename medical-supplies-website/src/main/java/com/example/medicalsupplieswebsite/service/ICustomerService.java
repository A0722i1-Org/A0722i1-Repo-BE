package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.CustomerInfo;
import com.example.medicalsupplieswebsite.entity.Customer;

public interface ICustomerService extends IService<Customer>{
    void saveCustomer(CustomerInfo customerInfo);


    void update(CustomerInfo customerInfo, Long id);

}
