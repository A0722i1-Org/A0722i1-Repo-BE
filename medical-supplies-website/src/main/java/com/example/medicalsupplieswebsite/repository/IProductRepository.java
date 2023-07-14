package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
