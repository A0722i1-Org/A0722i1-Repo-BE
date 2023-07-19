package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.repository.IProductRepository;
import com.example.medicalsupplieswebsite.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iproductRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<ProductHomeDto> findAllProducts(Pageable pageable) {
        return iproductRepository.findAllProduct(pageable);
    }

    @Override
    public Page<ProductHomeDto> searchProduct(String productName, String categoryName,
                                              String minPrice, String maxPrice, Pageable pageable) {
        return iproductRepository.searchProduct(productName,categoryName,minPrice,maxPrice, pageable);
    }

    @Override
    public List<ProductPriceDto> getProductListPrice() {
        return iproductRepository.getProductPrice();
    }

}
