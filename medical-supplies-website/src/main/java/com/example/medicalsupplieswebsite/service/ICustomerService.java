package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.dto.CustomerInfo;
import com.example.medicalsupplieswebsite.entity.Customer;

public interface ICustomerService extends IService<Customer>{
 /**
  * HieuLD
  * @param customerInfo
  */
 void saveCustomer(CustomerInfo customerInfo);
    void update(CustomerInfo customerInfo, Long id);

    Customer findByUsername(String username);
    CustomerDto findByPhoneCustomer(String phone);
    /**
     * A0722I1-KhanhNL
     */
    CustomerUserDetailDto findUserDetailByUsername(String username);
    String findAddressByCustomerId(Long customerId );

}
