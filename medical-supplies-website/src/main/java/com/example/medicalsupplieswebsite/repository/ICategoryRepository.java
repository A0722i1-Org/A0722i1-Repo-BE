package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    @Query( value="SELECT * FROM category " , nativeQuery = true)
    List<Category> findAll();
}
