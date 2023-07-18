package com.example.medicalsupplieswebsite.dto;

import com.example.medicalsupplieswebsite.entity.Category;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.entity.ProductInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.aspectj.apache.bcel.ExceptionConstants;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDTO {


    @NotBlank(message = "Tên vật tư không được để trống")
    private String productName;

    @NotNull(message = "Giá vật tư không được để trống")
    private Integer productPrice;

    @NotNull(message = "Số lượng vật tư không được để trống")
    private Integer productQuantity;

    @NotBlank(message = "Ảnh vật tư không được để trống")
    private String productImg;

    @NotBlank(message = "Mã vật tư không được để trống")
    private String productCode;

    @NotNull(message ="Hạn sử dụng không được để trống")
    private Date expireDate;

    private String category;

    private String productInfo;

    private String customer;


    public ProductDTO(String productName, Integer productPrice, Integer productQuantity, String productImg, String productCode, Date expireDate, String category, String productInfo, String customer) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImg = productImg;
        this.productCode = productCode;
        this.expireDate = expireDate;
        this.category = category;
        this.productInfo = productInfo;
        this.customer = customer;
    }
}
