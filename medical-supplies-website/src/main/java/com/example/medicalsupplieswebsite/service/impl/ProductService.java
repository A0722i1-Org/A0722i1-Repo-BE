package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.dto.receipt_dto.ProductDTO;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.example.medicalsupplieswebsite.repository.IProductRepository;
import com.example.medicalsupplieswebsite.service.IProductService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

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
    public Product findByProductId(Long productId) {
        return iProductRepository.findByProductId(productId);
    }

    @Override
    public Page<Supply> findAllSuppliesForAdmin(Pageable pageable) {
        return iProductRepository.findAllSuppliesForAdmin(pageable);
    }

    @Override
    public Page<Supply> searchSupplies(String productCode, String productName, String categoryName,
                                       String customerName, String expireDateStart, String expireDateEnd,
                                       Pageable pageable) {
        return iProductRepository.searchSupplies(productCode, productName, categoryName, customerName, expireDateStart, expireDateEnd, pageable);
    }

    @Override
    public List<ProductDTO> getAllProductByCustomerID(Long customerId) {
        return iProductRepository.getAllProductByCustomerID(customerId);
    }

    @Override
    public ProductDTO findProductDTOByProductId(Long productId) {
        return iProductRepository.findProductDTOByProductId(productId);
    }
}
