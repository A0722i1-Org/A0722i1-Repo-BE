package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.repository.ICustomerRepository;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    @Autowired
    CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> customers = this.customerRepository.findAllCustomers(pageable);
        return customers;
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
        customerRepository.deleteCustomerId(id);
    }


    @Override
    public List<Customer> searchCustomers(String type, String name, String address, String phone) {
        if (type == null) {
            type = "";
        }
        if (name == null) {
            name = "";
        }
        if (address == null) {
            address = "";
        }
        if (phone == null) {
            phone = "";
        }
        return this.customerRepository.searchCustomer(type, name, address, phone);
    }
}
