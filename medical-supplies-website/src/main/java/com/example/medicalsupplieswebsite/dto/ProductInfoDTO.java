package com.example.medicalsupplieswebsite.dto;

import com.example.medicalsupplieswebsite.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDTO {
    private Long infoId;
    private String infoIntroduction;
    private String infoDescription;
    private String trademark;
    private String placeOfManufacture;

    public ProductInfoDTO(ProductInfo productInfo) {
        this.infoId = productInfo.getInfoId();
        this.infoIntroduction = productInfo.getInfoIntroduction();
        this.infoDescription = productInfo.getInfoDescription();
        this.trademark = productInfo.getTrademark();
        this.placeOfManufacture = productInfo.getPlaceOfManufacture();
    }
}
