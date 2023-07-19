package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Cart;

public interface ICartService extends IService<Cart>{
    Cart findByUsername(String username);
    void deleteById(Long id);
    Cart save(Cart cart);
    Cart findLastCart();
}
