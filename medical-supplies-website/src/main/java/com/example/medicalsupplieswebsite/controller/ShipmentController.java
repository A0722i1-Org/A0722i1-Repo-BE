package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.dto.shipmentdto.ShipmentDetailDto;
import com.example.medicalsupplieswebsite.dto.shipmentdto.ShipmentDto;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.entity.Shipment;
import com.example.medicalsupplieswebsite.service.*;
import com.example.medicalsupplieswebsite.validate.ShipmentValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/shipment")
public class ShipmentController {
    @Autowired
    IShipmentTypeService shipmentTypeService;

    @Autowired
    IShipmentService shipmentService;

    @Autowired
    IShipmentDetailService shipmentDetailService;

    @Autowired
    IProductService productService;

    @Autowired
    ICustomerService customerService;

    /*PhucND code luu hoa don xuat kho*/
    @PostMapping("/create")
    public ResponseEntity<?> createShipment(@Valid @RequestBody ShipmentDto shipmentDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        shipmentService.addShipment(shipmentDto.getInvoiceCode(), shipmentDto.getDateOfCreate(), shipmentDto.getShipmentTypeId(), shipmentDto.getCustomerId(), shipmentDto.getEmployeeId());
        Long shipmentID = shipmentService.findByShipmentIDInvoice(shipmentDto.getInvoiceCode());
        for (ShipmentDetailDto list : shipmentDto.getListShipmentDetailDtos()) {
            if (productService.findByIdProductShipment(list.getProductId()) != null) {
                productService.findByIdProductShipment(list.getProductId()).setProductQuantity(productService.findByIdProductShipment(list.getProductId()).getProductQuantity() - list.getQuantity());
            }
            shipmentDetailService.addNewShipmentDetail(list.getQuantity(), list.getNote(), shipmentID, list.getProductId());
        }
        return new ResponseEntity<>(shipmentDto, HttpStatus.CREATED);
    }

    /*PhucND code select theo phone*/
    @GetMapping("/phone/{phone}")
    public ResponseEntity<?> findByPhoneCustomer(@PathVariable("phone") String phone) {
        CustomerDto customer = customerService.findByPhoneCustomer(phone);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
