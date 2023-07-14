package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartDetailRepository extends JpaRepository<CartDetail,Long> {
}
