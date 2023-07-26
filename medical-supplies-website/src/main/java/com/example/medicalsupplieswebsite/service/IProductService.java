package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.ProductDTO;
import com.example.medicalsupplieswebsite.entity.Product;

import java.util.List;
import java.util.Map;

public interface IProductService extends IService<Product>{

    Product findByIdNative(Long id);

    String existsProductName(String product_name);

    void saveProduct(Product product);


    void updateProductValid(ProductDTO product);

}
