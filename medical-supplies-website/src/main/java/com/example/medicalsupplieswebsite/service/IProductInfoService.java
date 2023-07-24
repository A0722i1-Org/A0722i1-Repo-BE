package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.ProductInfo;

public interface IProductInfoService extends IService<ProductInfo> {
    ProductInfo findById(Long id);
}
