package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.CartDetail;
import com.example.medicalsupplieswebsite.repository.ICartDetailRepository;
import com.example.medicalsupplieswebsite.service.ICartDetailService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService implements ICartDetailService {
    private final ICartDetailRepository cartDetailRepository;

    @Autowired
    CartDetailService(ICartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
    }

    @Override
    public Page<CartDetail> findAll(Pageable pageable) {
        return this.cartDetailRepository.findAll(pageable);
    }

    @Override
    public CartDetail findById(Long id) {
        return this.cartDetailRepository.findById(id).orElse(null);
    }

    @Override
    public CartDetail save(CartDetail cartDetail) {
        if (cartDetail != null) {
            Long cart_detail_id = cartDetail.getCartDetailId();
            Long product_id = cartDetail.getProduct().getProductId();
            int quantity = cartDetail.getQuantity();
            boolean status = cartDetail.isStatus();
            Long cart_id = cartDetail.getCartId();
            if (cart_detail_id != null) {
                this.cartDetailRepository.updateCart(product_id, quantity, status, cart_id, cart_detail_id);
            } else {
                this.cartDetailRepository.insertCart(product_id, quantity, status, cart_id);
            }
        }
        return cartDetail;
    }

    @Override
    public void deleteById(Long id) {
        this.cartDetailRepository.deleteById(id);
    }

    @Override
    public List<CartDetail> findByCartId(Long id) {
        return this.cartDetailRepository.findByCartId(id);
    }
}
