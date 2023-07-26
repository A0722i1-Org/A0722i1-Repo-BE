package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Position;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.example.medicalsupplieswebsite.repository.IProductInforRepository;
import com.example.medicalsupplieswebsite.service.IProductInfoService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoService implements IProductInfoService {

    @Autowired
    private IProductInforRepository productInforRepository;

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

    @Override
    public List<ProductInfo> productList() {
        return productInforRepository.findAll();
    }
}