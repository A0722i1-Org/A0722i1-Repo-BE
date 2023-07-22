package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Position;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.example.medicalsupplieswebsite.service.IProductInfoService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoService implements IProductInfoService {

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductInfo findById(Long id) {
        return null;
    }

    @Override
    public ProductInfo update(ProductInfo productInfo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
