package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.repository.IAccountRepository;
import com.example.medicalsupplieswebsite.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements IService<Customer> {
    private final ICustomerRepository customerRepository;

    @Autowired
    CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
