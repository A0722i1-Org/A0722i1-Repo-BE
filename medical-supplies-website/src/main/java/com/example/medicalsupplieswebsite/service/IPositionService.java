package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.entity.Position;

import java.util.List;

public interface IPositionService extends IService<Position>{
    List<Position> findAllPos();
}
