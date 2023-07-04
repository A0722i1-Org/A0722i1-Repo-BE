package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Cart;
import com.example.medicalsupplieswebsite.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartService implements IService<Cart> {
    private final ICartRepository cartRepository;

    @Autowired
    CartService(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return this.cartRepository.findAll(pageable);
    }

    @Override
    public Cart findById(Long id) {
        return this.cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart save(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        this.cartRepository.deleteById(id);
    }
}
