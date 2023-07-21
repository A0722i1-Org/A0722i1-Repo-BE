package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductInfoDTO;
import com.example.medicalsupplieswebsite.error.NotFoundById;
import com.example.medicalsupplieswebsite.service.impl.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/product-info")
public class ProductInfoController {

    @Autowired
    ProductInfoService productInfoService;

    @GetMapping("/{id}")
    private ResponseEntity<ProductInfoDTO> findById(@PathVariable Long id) throws NotFoundById {
        return new ResponseEntity<>(new ProductInfoDTO(productInfoService.findById(id)), HttpStatus.OK);
    }
}
