package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

//    Pham Anh Tài
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

    //    Pham Anh Tài
    @Transactional
    @Query(value = "SELECT * FROM product WHERE id = :id", nativeQuery = true)
    Optional<Product> findByIdNative(@Param("id") Long id);

    //    Pham Anh Tài
    @Transactional
    @Query(value = "select  product_name from product where product_name = ?1", nativeQuery = true)
    String existsProductName(String product_name);
}
