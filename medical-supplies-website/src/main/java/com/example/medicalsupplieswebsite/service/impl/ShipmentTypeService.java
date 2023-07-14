package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.ShipmentType;
import com.example.medicalsupplieswebsite.service.IService;
import com.example.medicalsupplieswebsite.service.IShipmentTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShipmentTypeService implements IShipmentTypeService {


    @Override
    public Page<ShipmentType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ShipmentType findById(Long id) {
        return null;
    }

    @Override
    public ShipmentType save(ShipmentType shipmentType) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
