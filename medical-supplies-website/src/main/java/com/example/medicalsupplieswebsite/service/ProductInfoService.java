package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Position;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoService implements IService<ProductInfo> {

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductInfo findById(Long id) {
        return null;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
