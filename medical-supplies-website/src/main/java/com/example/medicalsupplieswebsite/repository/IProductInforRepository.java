package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProductInforRepository extends JpaRepository<ProductInfo, Long> {

    @Query(value = "SELECT pi.info_id, pi.info_introduction, pi.info_description, pi.trademark, pi.place_of_manufacture, " +
            "p.product_img, p.product_name, p.product_price, p.product_quantity " +
            "FROM product_info pi " +
            "INNER JOIN product p ON pi.info_id = p.product_id " +
            "where pi.info_id = :id",
            nativeQuery = true)
    Optional<ProductInfo> findByIdProductInfo(@Param("id") Long id);
}
