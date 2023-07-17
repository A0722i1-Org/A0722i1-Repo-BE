package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.CartDetail;

import java.util.List;

public interface ICartDetailService extends IService<CartDetail>{
    List<CartDetail> findByCartId(Long id);

    CartDetail save(CartDetail cartDetail);

}
