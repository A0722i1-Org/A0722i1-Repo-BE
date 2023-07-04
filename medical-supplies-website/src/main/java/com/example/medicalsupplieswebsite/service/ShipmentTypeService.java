package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.ShipmentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShipmentTypeService implements IService<ShipmentType> {


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
