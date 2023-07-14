package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.ShipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipmentTypeRepository extends JpaRepository<ShipmentType,Long> {
}
