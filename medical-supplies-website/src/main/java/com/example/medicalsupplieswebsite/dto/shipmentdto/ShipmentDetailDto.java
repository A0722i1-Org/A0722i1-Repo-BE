package com.example.medicalsupplieswebsite.dto.shipmentdto;

import com.example.medicalsupplieswebsite.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.catalina.webresources.StandardRoot;

@Getter
@Setter
@RequiredArgsConstructor
public class ShipmentDetailDto {
    private Long productId;
    private int quantity;
    private String note;
}
