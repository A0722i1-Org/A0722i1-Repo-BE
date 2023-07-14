package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Shipment;
import com.example.medicalsupplieswebsite.entity.ShipmentDetail;
import com.example.medicalsupplieswebsite.service.IService;
import com.example.medicalsupplieswebsite.service.IShipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService implements IShipmentService {


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
