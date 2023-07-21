package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService extends IService<CustomerType>{
    List<CustomerType> findAllCustomerType();
}
