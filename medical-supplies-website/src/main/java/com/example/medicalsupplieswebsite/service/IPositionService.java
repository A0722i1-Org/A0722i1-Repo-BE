package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    Position findById(Integer id);
}
