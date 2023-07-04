package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IService<Product> {

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
