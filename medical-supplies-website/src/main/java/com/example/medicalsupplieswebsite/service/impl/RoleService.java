package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Receipt;
import com.example.medicalsupplieswebsite.entity.Role;
import com.example.medicalsupplieswebsite.service.IRoleService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
