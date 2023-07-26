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
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    /*
    A0722I1-TaiPA
    */
    @Transactional
    @Query(value = "SELECT * FROM product WHERE product_id = :id", nativeQuery = true)
    Optional<Product> findByIdNative(@Param("id") Long id);


    /*
    A0722I1-TaiPA
    */
    @Transactional
    @Query(value = "select  product_name from product where product_name = ?1", nativeQuery = true)
    String existsProductName(String product_name);

    /*
     A0722I1-TaiPA
    */
    @Modifying
    @Transactional
    @Query(value = "insert into product(expire_date, is_enable, product_code, product_img, product_name, product_price, product_quantity, category_id, customer_id, product_info_id)" +
            " values(:expire_date, :is_enable, :product_code, :product_img, :product_name, :product_price, :product_quantity, :category_id, :customer_id, :product_info_id)",
            nativeQuery = true)
    void saveProductNative(@Param("expire_date") Date expire_date,
                              @Param("is_enable") boolean is_enable,
                              @Param("product_code") String product_code,
                              @Param("product_img") String product_img,
                              @Param("product_name") String product_name,
                              @Param("product_price") Integer product_price,
                              @Param("product_quantity") Integer product_quantity,
                              @Param("category_id") String category_id,
                              @Param("customer_id") String customer_id,
                              @Param("product_info_id") String product_info_id
    );

    /*
    A0722I1-TaiPA
    */
    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET expire_date = :expire_date, is_enable = :is_enable, product_code = :product_code, product_img = :product_img, product_name = :product_name, "+
            "product_price =  :product_price, product_quantity = :product_quantity, category_id = :category_id, customer_id = :customer_id, product_info_id = :product_info_id WHERE product_id = :id",nativeQuery = true)
    void updateProduct(@Param("expire_date") Date expire_date,
                              @Param("is_enable") boolean is_enable,
                              @Param("product_code") String product_code,
                              @Param("product_img") String product_img,
                              @Param("product_name") String product_name,
                              @Param("product_price") Integer product_price,
                              @Param("product_quantity") Integer product_quantity,
                              @Param("category_id") String category_id,
                              @Param("customer_id") String customer_id,
                              @Param("product_info_id") String product_info_id,
                              @Param("id") Long id

    );
}
