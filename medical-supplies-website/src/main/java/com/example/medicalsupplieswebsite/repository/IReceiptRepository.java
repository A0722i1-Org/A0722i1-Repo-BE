package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceiptRepository extends JpaRepository<Receipt,Long> {
}
