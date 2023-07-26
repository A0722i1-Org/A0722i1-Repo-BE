package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.CartWithDetail;
import com.example.medicalsupplieswebsite.dto.EmailDetails;
import com.example.medicalsupplieswebsite.entity.*;
import com.example.medicalsupplieswebsite.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    //Author: NhatLH
    private final ICartService cartService;
    private final ICartDetailService cartDetailService;
    private final IEmailService emailService;

    @Autowired
    CartController(ICartService cartService, ICartDetailService cartDetailService, IEmailService emailService) {
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
        this.emailService = emailService;
    }
}
