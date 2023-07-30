package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Payment;
import com.example.medicalsupplieswebsite.repository.IPaymentRepository;
import com.example.medicalsupplieswebsite.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    IPaymentRepository paymentRepository;

    @Override
    public Page<Payment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Payment findById(Long id) {
        return this.paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Payment findPaymentBySecureHash(String hashCode) {
        return this.paymentRepository.findPaymentBySecureHash(hashCode).orElse(null);
    }
}
