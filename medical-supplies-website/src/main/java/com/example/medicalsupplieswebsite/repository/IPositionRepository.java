package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Long> {
}
