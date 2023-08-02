package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.CustomerInfo;
import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.dto.receipt_dto.SupplierDTO;
import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
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
import java.util.List;
import java.util.Optional;





@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    @Autowired
    CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> customers = this.iCustomerRepository.findAllCustomers(pageable);
        return customers;
    }

    /**
     *
     * A0722I1-HieuLD
     */
    @Override
    public void saveCustomer(CustomerInfo customerInfo) {
        iCustomerRepository.insertCustomer(customerInfo.getName(), customerInfo.getEmail(), customerInfo.getPhone(),
                customerInfo.isGender(), customerInfo.getDateOfBirth(), customerInfo.getIdCard(),
                customerInfo.getCustomerAddress(), customerInfo.getCustomerImg(), customerInfo.getCustomerType(),
                customerInfo.getCustomerCode(), true);


    }

    /**
     *
     * A0722I1-HieuLD
     */
    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }


    @Override
    public Customer update(Customer customer) {
        return null;
    }


    /**
     *
     * A0722I1-HieuLD
     */
    @Override
    public void update(CustomerInfo customerInfo, Long id) {
        iCustomerRepository.updateCustomer(id, customerInfo.getName(), customerInfo.getEmail(), customerInfo.getPhone(),
                customerInfo.isGender(), customerInfo.getDateOfBirth(), customerInfo.getIdCard(),
                customerInfo.getCustomerAddress(), customerInfo.getCustomerImg(), customerInfo.getCustomerType(),
                customerInfo.getCart(), customerInfo.getAccount(), customerInfo.getCustomerCode(), true);

    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        iCustomerRepository.deleteCustomerId(id);
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


    public String findAddressByCustomerId(Long customerId) {
        return iCustomerRepository.findAddressByCustomerId(customerId);
    }

    @Override
    public List<SupplierDTO> getALlCustomerByCustomerTypeSupplier() {
        return iCustomerRepository.getALlCustomerByCustomerTypeSupplier().orElse(null);
    }

    @Override
    public CustomerDto findByPhoneCustomer(String phone) {
        return iCustomerRepository.findByPhoneCustomer(phone).orElse(null);
    }


    @Override
    public List<Customer> searchCustomers(String keyword) {
        return this.iCustomerRepository.searchCustomer(keyword);
    }
}
