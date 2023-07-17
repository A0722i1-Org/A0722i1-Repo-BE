package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Integer> {
    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @return List position
     */
    @Query("SELECT position FROM Position position")
    List<Position> findAll();

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param id
     * @return position was found by id
     */
    @Query("SELECT position FROM Position position WHERE position.id = ?1")
    Position findAllById(Integer id);
}
