package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Role;
import com.example.medicalsupplieswebsite.entity.ShipmentDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShipmentDetailService implements IService<ShipmentDetail> {


    @Override
    public Page<ShipmentDetail> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ShipmentDetail findById(Long id) {
        return null;
    }

    @Override
    public ShipmentDetail save(ShipmentDetail shipmentDetail) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
