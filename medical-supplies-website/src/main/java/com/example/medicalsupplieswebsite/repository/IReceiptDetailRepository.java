package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.ReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceiptDetailRepository extends JpaRepository<ReceiptDetail, Long> {
}
