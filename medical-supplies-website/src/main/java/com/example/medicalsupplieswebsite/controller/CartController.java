package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.CartWithDetail;
import com.example.medicalsupplieswebsite.entity.*;
import com.example.medicalsupplieswebsite.service.ICartDetailService;
import com.example.medicalsupplieswebsite.service.ICartService;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import com.example.medicalsupplieswebsite.service.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final ICartService cartService;
    private final ICartDetailService cartDetailService;
    private final ICustomerService customerService;
    private final IShipmentService shipmentService;

    @Autowired
    CartController(ICartService cartService, ICartDetailService cartDetailService, ICustomerService customerService, IShipmentService shipmentService) {
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
        this.customerService = customerService;
        this.shipmentService = shipmentService;
    }

    @GetMapping()
    public ResponseEntity<CartWithDetail> findCartByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        Customer customer = this.customerService.findByUsername(username);
        Cart cart = this.cartService.findByUsername(username);
        List<CartDetail> cartDetailList = this.cartDetailService.findByCartId(cart.getCartId());
        CartWithDetail cartWithDetail = new CartWithDetail();
//        cartWithDetail.setCartId(cart.getCartId());
//        cartWithDetail.setReceiverName(cart.getReceiverName());
//        cartWithDetail.setReceiverAddress(cart.getReceiverAddress());
//        cartWithDetail.setReceiverEmail(cart.getReceiverEmail());
//        cartWithDetail.setCustomer_id(customer.getCustomerId());
        cartWithDetail.setCart(cart);
        cartWithDetail.setCartDetailList(cartDetailList);
        return new ResponseEntity<CartWithDetail>(cartWithDetail, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CartWithDetail> updateCart(@PathVariable("id") Long id, @RequestBody CartWithDetail cartWithDetail) {
        Cart cart = cartWithDetail.getCart();
        this.cartService.save(cart);
        List<CartDetail> cartDetailList = cartWithDetail.getCartDetailList();
        for (CartDetail cartDetail : cartDetailList) {
            this.cartDetailService.save(cartDetail);
        }
        return new ResponseEntity<CartWithDetail>(cartWithDetail, HttpStatus.OK);
    }

    @PutMapping("/checkout")
    public ResponseEntity<CartWithDetail> checkout(@PathVariable("id") Long id, @RequestBody CartWithDetail cartWithDetail) {
        Shipment shipment = new Shipment();
        List<CartDetail> checkoutList = new ArrayList<>();
        Cart cart = cartWithDetail.getCart();
        this.cartService.save(cart);
        List<CartDetail> cartDetailList = cartWithDetail.getCartDetailList();
        for (CartDetail cartDetail : cartDetailList) {
            checkoutList.add(cartDetail);
            this.cartDetailService.save(cartDetail);
        }
        return new ResponseEntity<CartWithDetail>(cartWithDetail, HttpStatus.OK);
    }
}
