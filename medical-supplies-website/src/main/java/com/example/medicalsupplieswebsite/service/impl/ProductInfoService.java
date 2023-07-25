package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Position;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.example.medicalsupplieswebsite.repository.IProductInforRepository;
import com.example.medicalsupplieswebsite.service.IProductInfoService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoService implements IProductInfoService {


    @Autowired
    IProductInforRepository productInforRepository;

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return null;
    }

    /**
     * A0722I1 - ThanhDT
     * @param id
     * @return
     */
    @Override
    public ProductInfo findById(Long id) {
        return productInforRepository.findByIdProductInfo(id).orElse(null);
    }

    @Override
    public ProductInfo update(ProductInfo productInfo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
