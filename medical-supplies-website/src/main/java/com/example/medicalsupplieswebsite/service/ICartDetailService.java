package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.CartDetail;

import java.util.List;

public interface ICartDetailService extends IService<CartDetail>{
    //Author: NhatLH
    void add(Long productId, Long cartId);

    List<CartDetail> findByCartId(Long id);

    CartDetail update(CartDetail cartDetail);

}
