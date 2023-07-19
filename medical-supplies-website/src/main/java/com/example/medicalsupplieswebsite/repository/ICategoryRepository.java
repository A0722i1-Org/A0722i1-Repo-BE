package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
