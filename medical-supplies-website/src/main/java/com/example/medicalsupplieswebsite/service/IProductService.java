package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface IProductService extends IService<Product>{
    Product findByProductId(Long productId);
    Page<Supply> findAllSuppliesForAdmin(Pageable pageable);
    Page<Supply> searchSupplies(String productCode, String productName,
                                String categoryName, String customerName,
                                String expireDateStart, String expireDateEnd, Pageable pageable);

    Product UpdateProductByFiled(Long id, Map<String, Object> fields);

    Product findByIdNative(Long id);

    String existsProductName(String product_name);
}
