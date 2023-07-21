package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.repository.ICustomerTypeRepository;
import com.example.medicalsupplieswebsite.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerRepository;

    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CustomerType findById(Long id) {
        return null;
    }

    @Override
    public CustomerType save(CustomerType customerType) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerRepository.findAll();
    }
}
