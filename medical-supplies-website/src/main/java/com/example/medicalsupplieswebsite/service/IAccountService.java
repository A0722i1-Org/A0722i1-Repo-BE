package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Account;

public interface IAccountService extends IService<Account>{
    /*
     * NhanTQ
     * @param username
     * @param newPass
     */
    void changePassword(String username,String newPass);
}
