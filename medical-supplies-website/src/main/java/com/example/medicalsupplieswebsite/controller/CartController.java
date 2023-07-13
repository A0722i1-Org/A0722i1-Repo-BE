package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.service.impl.CartDetailService;
import com.example.medicalsupplieswebsite.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;
    private final CartDetailService cartDetailService;

    @Autowired
    CartController(CartService cartService, CartDetailService cartDetailService) {
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
    }
}
