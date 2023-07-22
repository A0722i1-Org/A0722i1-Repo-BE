package com.example.medicalsupplieswebsite.dto.shipmentdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public interface CustomerDto {
     Long getCustomer_Id();
     String getName();
     String getPhone();
     String getCustomer_Address();
}
