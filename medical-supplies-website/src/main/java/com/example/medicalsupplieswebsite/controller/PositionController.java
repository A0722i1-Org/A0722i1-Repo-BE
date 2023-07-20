package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.entity.Position;
import com.example.medicalsupplieswebsite.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/positions")
public class PositionController {
    @Autowired
    private IPositionService iPositionService;

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @return list position
     */
    @GetMapping("")
    public Page<Position> getListPosition() {
        return iPositionService.findAll(Pageable.unpaged());
    }
}
