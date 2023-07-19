package com.example.medicalsupplieswebsite.dto.shipmentdto;

import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class ShipmentDto {
    private Long shipmentId;
    @NotBlank(message = "Mã hóa đơn không được để trống")
    @Pattern(regexp = "HD-\\d{3}", message = "Mã hóa đơn không đúng định dạng HD-xxx")
    private String invoiceCode;
    private Date dateOfCreate;
    private Long employeeId;
    private Long customerId;
    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;
    private Long shipmentTypeId;
    private List<ShipmentDetailDto> listShipmentDetailDtos;
}
