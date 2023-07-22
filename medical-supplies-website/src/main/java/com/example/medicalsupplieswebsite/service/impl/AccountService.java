package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.repository.IAccountRepository;
import com.example.medicalsupplieswebsite.service.IAccountService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository;
    @Autowired
    AccountService(IAccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    /*
     * NhanTQ
     * @param username
     * @param newPass
     */
    @Override
    public void changePassword(String username, String newPass) {
        accountRepository.changePassword(username,newPass);
    }
}
