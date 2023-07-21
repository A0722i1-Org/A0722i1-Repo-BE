package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.CustomerInfo;
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
        return customerRepository.findAll(pageable);
    }

    @Override
    public void saveCustomer(CustomerInfo customerInfo) {
        customerRepository.insertCustomer(customerInfo.getName(),customerInfo.getEmail(),customerInfo.getPhone(),
                customerInfo.isGender(),customerInfo.getDateOfBirth(),customerInfo.getIdCard(),
                customerInfo.getCustomerAddress(), customerInfo.getCustomerImg(), customerInfo.getCustomerType(),
                customerInfo.getCustomerCode(),false);

    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }


    @Override
    public void update(CustomerInfo customerInfo, Long id) {
        customerRepository.updateCustomer(id, customerInfo.getName(),customerInfo.getEmail(),customerInfo.getPhone(),
                customerInfo.isGender(),customerInfo.getDateOfBirth(),customerInfo.getIdCard(),
                customerInfo.getCustomerAddress(), customerInfo.getCustomerImg(), customerInfo.getCustomerType(),
                customerInfo.getCart(),customerInfo.getAccount(),customerInfo.getCustomerCode(),false);

    }

    @Override
    public Customer save(Customer customer) {

        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
