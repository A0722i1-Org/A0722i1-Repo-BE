package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Category;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements IService<Category> {
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
