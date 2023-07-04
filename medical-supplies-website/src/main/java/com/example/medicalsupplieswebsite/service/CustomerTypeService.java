package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService implements IService<CustomerType> {

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
}
