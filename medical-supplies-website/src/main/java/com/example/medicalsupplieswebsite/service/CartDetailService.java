package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.CartDetail;
import com.example.medicalsupplieswebsite.repository.ICartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartDetailService implements IService<CartDetail> {
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
        return this.cartDetailRepository.save(cartDetail);
    }

    @Override
    public void deleteById(Long id) {
        this.cartDetailRepository.deleteById(id);
    }
}
