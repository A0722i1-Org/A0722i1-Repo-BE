package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
    @Query( value="SELECT * FROM category " , nativeQuery = true)
    List<Category> findAll();
}
