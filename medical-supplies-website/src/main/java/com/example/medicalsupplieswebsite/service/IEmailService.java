package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.EmailDetails;
import com.example.medicalsupplieswebsite.entity.Cart;

public interface IEmailService {
    //Author: NhatLH
    String sendSimpleMail(EmailDetails emailDetails);

    void emailProcess(Cart cart, long totalAmount);
}