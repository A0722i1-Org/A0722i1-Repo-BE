package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.ReceiptDetail;
import com.example.medicalsupplieswebsite.service.IReceiptDetailService;
import com.example.medicalsupplieswebsite.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReceiptDetailService implements IReceiptDetailService {


    @Override
    public Page<ReceiptDetail> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ReceiptDetail findById(Long id) {
        return null;
    }

    @Override
    public ReceiptDetail save(ReceiptDetail receiptDetail) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
