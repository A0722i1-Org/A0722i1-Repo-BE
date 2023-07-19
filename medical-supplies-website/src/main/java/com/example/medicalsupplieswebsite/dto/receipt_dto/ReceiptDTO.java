package com.example.medicalsupplieswebsite.dto.receipt_dto;

import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ReceiptDTO {
    private Long receiptId;
    @NotNull(message = "Không được để trống")
    private Long receiptTypeId;
    @NotBlank(message = "Không được để trống")
    private String invoiceCode;
    private Date dateOfCreate;
    @NotNull(message = "Không được để trống")
    private Long employeeId;
    @NotNull(message = "Không được để trống")
    private Long customerId;
    private String customerAddress;
    private List<ReceiptDetailDTO> receiptDetailDTOS;
}
