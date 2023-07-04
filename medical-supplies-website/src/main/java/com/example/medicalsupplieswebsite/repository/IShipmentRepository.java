package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipmentRepository extends JpaRepository<Shipment,Long> {
}
