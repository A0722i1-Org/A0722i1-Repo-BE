package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.ProductCreateDTO;
import com.example.medicalsupplieswebsite.entity.Product;

public interface IProductService extends IService<Product>{

    Product findByIdNative(Long id);

    String existsProductName(String product_name);

    void saveProduct(Product product);

    void updateProductValid(ProductCreateDTO product);

}
