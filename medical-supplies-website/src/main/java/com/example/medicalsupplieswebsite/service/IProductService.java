package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Product;

import java.util.Map;

public interface IProductService extends IService<Product>{

    Product UpdateProductByFiled(Long id, Map<String, Object> fields);

    Product findByIdNative(Long id);

    String existsProductName(String product_name);
}
