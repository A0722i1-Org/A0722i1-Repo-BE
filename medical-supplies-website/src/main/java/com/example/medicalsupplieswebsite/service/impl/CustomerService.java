package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.repository.ICustomerRepository;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
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

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username).orElse(null);
    }

    @Override
    public CustomerDto findByPhoneCustomer(String phone) {
        return customerRepository.findByPhoneCustomer(phone).orElse(null);
    }
}
