package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Shipment;
import com.example.medicalsupplieswebsite.entity.ShipmentDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService implements IService<Shipment> {


    @Override
    public Page<Shipment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Shipment findById(Long id) {
        return null;
    }

    @Override
    public Shipment save(Shipment shipment) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
