package com.example.medicalsupplieswebsite.validate;

import com.example.medicalsupplieswebsite.dto.shipmentdto.ShipmentDetailDto;
import com.example.medicalsupplieswebsite.dto.shipmentdto.ShipmentDto;
import com.example.medicalsupplieswebsite.service.impl.ProductService;
import com.example.medicalsupplieswebsite.service.impl.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ShipmentValidate implements Validator {
    @Autowired
    ShipmentService shipmentService;

    @Autowired
    ProductService productService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ShipmentDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof ShipmentDto)){
            return;
        }
    }
}
