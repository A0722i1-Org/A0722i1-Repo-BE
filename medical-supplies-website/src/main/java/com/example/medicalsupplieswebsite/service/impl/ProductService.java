package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.example.medicalsupplieswebsite.error.NotFoundById;
import com.example.medicalsupplieswebsite.repository.IProductRepository;
import com.example.medicalsupplieswebsite.repository.IProductRepository;
import com.example.medicalsupplieswebsite.service.IProductService;
import com.example.medicalsupplieswebsite.service.IService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Tuple;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @SneakyThrows
    @Override
    public Product findById(Long id) {
        Optional<Product> product = iProductRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new NotFoundById("Không tìm thấy bất kì nhân viên nào có mã số: " + id);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }


    @Override
    public String existsProductName(String product_name) {
         return iProductRepository.existsProductName(product_name);
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
    public Product UpdateProductByFiled(Long id, Map<String, Object> fields) {
        Optional<Product> existingProduct = iProductRepository.findById(id);
        if (existingProduct.isPresent()){
            fields.forEach((key,value) -> {
                Field field  = ReflectionUtils.findField(Product.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,existingProduct.get(),value);
            });
            return iProductRepository.save(existingProduct.get());
        }
        return null;
    }

    @Override
    public Product findByIdNative(Long id) {
        Optional<Product> product = iProductRepository.findByIdNative(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

}




