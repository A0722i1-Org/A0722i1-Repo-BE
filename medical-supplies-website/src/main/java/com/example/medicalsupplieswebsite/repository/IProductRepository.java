package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Category;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Date;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into product(product_id, productName, productPrice, productQuantity, productImg, productCode, expireDate,isEnable, category, productInfo) values " +
            "(:productName,:productPrice,:productQuantity,:productImg,:productCode,:expireDate,:isEnable,:category,:productInfo)",
            nativeQuery = true)
    Integer saveProduct(@Param("productName") String productName,
                          @Param("productPrice") String productPrice,
                          @Param("productQuantity") String productQuantity,
                          @Param("productImg") String productImg,
                          @Param("productCode") String productCode,
                          @Param("expireDate") String expireDate,
                          @Param("isEnable") String isEnable,
                          @Param("category") Double category,
                          @Param("productInfo") String productInfo
    );
}
