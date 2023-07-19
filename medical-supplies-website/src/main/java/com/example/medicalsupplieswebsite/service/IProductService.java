package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product>{
    Product findByIdProductShipment(Long productId);
    Product findByProductId(Long productId);
    Page<Supply> findAllSuppliesForAdmin(Pageable pageable);
    Page<Supply> searchSupplies(String productCode, String productName,
                                String categoryName, String customerName,
                                String expireDateStart, String expireDateEnd, Pageable pageable);
    Page<ProductHomeDto> findAllProducts(Pageable pageable);
    Page<ProductHomeDto> searchProduct(String productName,
                                       String categoryName, String minPrice, String maxPrice, Pageable pageable);
    List<ProductPriceDto> getProductListPrice();
}
