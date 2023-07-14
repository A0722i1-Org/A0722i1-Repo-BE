package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.entity.Position;
import com.example.medicalsupplieswebsite.service.IPositionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {

    @Override
    public Page<Position> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Position findById(Long id) {
        return null;
    }

    @Override
    public Position save(Position position) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
