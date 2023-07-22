package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Position;
import com.example.medicalsupplieswebsite.repository.IPositionRepository;
import com.example.medicalsupplieswebsite.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;

    @Override
    public Page<Position> findAll(Pageable pageable) {
        return (Page<Position>) positionRepository.findAll();
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public Position save(Position position) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Position> findAllPos() {
        return positionRepository.findAll();
    }
}
