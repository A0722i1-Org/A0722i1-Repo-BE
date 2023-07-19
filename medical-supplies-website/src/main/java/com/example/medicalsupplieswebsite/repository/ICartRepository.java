package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {

}
