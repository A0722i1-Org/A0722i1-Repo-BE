package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.ProductDTO;
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
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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
        Optional<Product> employee = productRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new NotFoundById("Không tìm thấy bất kì nhân viên nào có mã số: " + id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void saveProduct(Product product) {
         productRepository.saveProductNative(
                product.getExpireDate(),
                product.isEnable(),
                product.getProductCode(),
                product.getProductImg(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQuantity(),
                String.valueOf(product.getCategory().getCategoryId()),
                String.valueOf(product.getCustomer().getCustomerId()),
                String.valueOf(product.getProductInfo().getInfoId())
        );
    }



    @Override
    public void deleteById(Long id) {

    }


    @SneakyThrows
    @Override
    public Product findByIdNative(Long id) {
        Optional<Product> product = productRepository.findByIdNative(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new NotFoundById("Không tìm thấy bất kì nhân viên nào có mã số: " + id);
    }

    @Override
    public String existsProductName(String product_name) {
        return productRepository.existsProductName(product_name);
    }

    @Override
    public void updateProductValid(ProductDTO product) {
        productRepository.updateProduct(
                product.getExpireDate(),
                false,
                product.getProductCode(),
                product.getProductImg(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQuantity(),
                String.valueOf(product.getCategory()),
                String.valueOf(product.getCustomer()),
                String.valueOf(product.getProductInfo()),
                product.getProductId()
        );
    }

}
