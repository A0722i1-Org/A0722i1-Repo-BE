package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.CustomerInfo;
import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.repository.IAccountRepository;
import com.example.medicalsupplieswebsite.repository.ICustomerRepository;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;



@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    @Autowired
    CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void saveCustomer(CustomerInfo customerInfo) {
        iCustomerRepository.insertCustomer(customerInfo.getName(),customerInfo.getEmail(),customerInfo.getPhone(),
                customerInfo.isGender(),customerInfo.getDateOfBirth(),customerInfo.getIdCard(),
                customerInfo.getCustomerAddress(), customerInfo.getCustomerImg(), customerInfo.getCustomerType(),
                customerInfo.getCustomerCode(),false);

    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }


    @Override
    public void update(CustomerInfo customerInfo, Long id) {
        iCustomerRepository.updateCustomer(id, customerInfo.getName(),customerInfo.getEmail(),customerInfo.getPhone(),
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

    @Override
    public Customer findByUsername(String username) {
        return iCustomerRepository.findByUsername(username).orElse(null);
    }

    /**
     * A0722I1-KhanhNL
     */
    @Override
    public CustomerUserDetailDto findUserDetailByUsername(String username) {
        Tuple tuple = iCustomerRepository.findUserDetailByUsername(username).orElse(null);

        if (tuple != null) {
            return CustomerUserDetailDto.TupleToCustomerDto(tuple);
        }

        return null;
    }

    @Override

    public CustomerDto findByPhoneCustomer(String phone) {
        return iCustomerRepository.findByPhoneCustomer(phone).orElse(null);
    }
    public String findAddressByCustomerId(Long customerId) {
        return iCustomerRepository.findAddressByCustomerId(customerId);
    }
}
