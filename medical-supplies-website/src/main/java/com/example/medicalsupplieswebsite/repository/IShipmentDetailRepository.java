package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.ShipmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipmentDetailRepository extends JpaRepository<ShipmentDetail,Long> {
}
