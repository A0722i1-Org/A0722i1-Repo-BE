package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.entity.Receipt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService implements IService<Receipt> {

    @Override
    public Page<Receipt> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Receipt findById(Long id) {
        return null;
    }

    @Override
    public Receipt save(Receipt receipt) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
