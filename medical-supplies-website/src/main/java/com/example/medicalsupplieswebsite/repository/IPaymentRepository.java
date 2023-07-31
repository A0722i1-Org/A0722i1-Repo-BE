package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findPaymentByTnxRef(String tnxRef);
}
