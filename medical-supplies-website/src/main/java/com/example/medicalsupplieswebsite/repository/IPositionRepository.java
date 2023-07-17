package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPositionRepository extends JpaRepository<Position, Long> {

    @Query(value = "select p.position_id, p.position_name from position p where p.position_id = :id",
            nativeQuery = true)
    Optional<Position> findById(@Param("id") Long id);
}
