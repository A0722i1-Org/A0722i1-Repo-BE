package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product>{
    Page<ProductHomeDto> findAllProducts(Pageable pageable);
    Page<ProductHomeDto> searchProduct(String productName,
                                       String categoryName, String minPrice, String maxPrice, Pageable pageable);
    List<ProductPriceDto> getProductListPrice();
}
