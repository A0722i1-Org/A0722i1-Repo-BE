package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.example.medicalsupplieswebsite.error.NotFoundById;
import com.example.medicalsupplieswebsite.repository.IProductRepository;
import com.example.medicalsupplieswebsite.service.IProductService;
import com.example.medicalsupplieswebsite.service.IService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }




    @SneakyThrows
    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new NotFoundById("Không tìm thấy bất kì nhân viên nào có mã số: " + id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Product UpdateProductByFiled(Long id, Map<String, Object> fields) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()){
            fields.forEach((key,value) -> {
                Field field  = ReflectionUtils.findField(Product.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,existingProduct.get(),value);
            });
            return productRepository.save(existingProduct.get());
        }
        return null;
    }

    @Override
    public Product findByIdNative(Long id) {
        Optional<Product> product = productRepository.findByIdNative(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @Override
    public String existsProductName(String product_name) {
        return productRepository.existsProductName(product_name);
    }

}
