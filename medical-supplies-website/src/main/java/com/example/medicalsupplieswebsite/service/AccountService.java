package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IService<Account> {
    private final IAccountRepository accountRepository;

    @Autowired
    AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return this.accountRepository.findAll(pageable);
    }

    @Override
    public Account findById(Long id) {
        return this.accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public void deleteById(Long id) {
        this.accountRepository.deleteById(id);
    }
}
