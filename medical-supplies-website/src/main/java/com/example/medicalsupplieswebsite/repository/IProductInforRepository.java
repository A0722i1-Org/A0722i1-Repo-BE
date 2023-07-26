package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductInforRepository extends JpaRepository<ProductInfo,Long> {
}
