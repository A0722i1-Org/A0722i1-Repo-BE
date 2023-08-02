package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Payment;


public interface IPaymentService extends IService<Payment>{
    Payment findPaymentBySecureHash(String hashCode);
}