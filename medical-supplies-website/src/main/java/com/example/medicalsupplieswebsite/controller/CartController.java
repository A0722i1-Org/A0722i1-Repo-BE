package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.CartWithDetail;
import com.example.medicalsupplieswebsite.entity.*;
import com.example.medicalsupplieswebsite.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public ResponseEntity<CartWithDetail> findCartByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Cart cart = this.cartService.findByUsername(username);
        Long id = cart.getCartId();
        List<CartDetail> cartDetailList = this.cartDetailService.findByCartId(id);
        CartWithDetail cartWithDetail = new CartWithDetail(cart, cartDetailList);
        return new ResponseEntity<>(cartWithDetail, HttpStatus.OK);
    }

    @GetMapping("/add/{productId}")
    public ResponseEntity<CartWithDetail> addProductToCart(@PathVariable("productId") Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Cart cart = this.cartService.findByUsername(username);
        Long cartId = cart.getCartId();
        CartDetail cartDetail = this.cartDetailService.checkAvailable(productId, cartId);
        if (cartDetail == null) {
            this.cartDetailService.add(productId, cartId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CartWithDetail> updateCart(@RequestBody CartWithDetail cartWithDetail) {
        Cart cart = cartWithDetail.getCart();
        this.cartService.update(cart);
        List<CartDetail> cartDetailList = cartWithDetail.getCartDetailList();
        for (CartDetail cartDetail : cartDetailList) {
            this.cartDetailService.update(cartDetail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/checkout")
    public ResponseEntity<CartWithDetail> checkout(@RequestBody CartWithDetail cartWithDetail) {
        Cart cart = cartWithDetail.getCart();
        List<CartDetail> cartDetailList = cartWithDetail.getCartDetailList();
        int totalAmount = 0;
        this.cartService.update(cart);
        for (CartDetail cartDetail : cartDetailList) {
            if (cartDetail.isStatus()) {
                totalAmount += cartDetail.getQuantity() * cartDetail.getProduct().getProductPrice();
            }
            this.cartDetailService.update(cartDetail);
        }
        if (totalAmount != 0) {
            this.emailService.emailProcess(cart, totalAmount);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
