package com.example.medicalsupplieswebsite.entity;

import com.example.medicalsupplieswebsite.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Integer productPrice;
    private Integer productQuantity;
    private String productImg;
    private String productCode;
    private Date expireDate;
    private boolean isEnable;



    @JsonIgnore
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "categoryId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "product_info_id",nullable = false,referencedColumnName = "infoId")
    private ProductInfo productInfo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false,referencedColumnName = "customerId")
    private Customer customer;

    public void decreaseQuantity(int quantity){
        int newQuantity = this.productQuantity - quantity;
        if (newQuantity >= 0) {
            this.setProductQuantity(newQuantity);
        } else {
            // Code xử lý thông báo cho nhân viên về việc số lượng hàng trong kho không còn đủ để giao dịch
        }
    }

    public void increaseQuantity(int quantity){
        this.productQuantity += quantity;
    }


    public Product(Long id){
        this.productId= id;
    }

    public Product(ProductDTO productDTO){
        this.productName = productDTO.getProductName();
        this.productPrice = productDTO.getProductPrice();
        this.productQuantity = productDTO.getProductQuantity();
        this.productImg = productDTO.getProductImg();
        this.productCode = productDTO.getProductCode();
        this.expireDate = productDTO.getExpireDate();
        this.isEnable = false;
        this.category = new Category(Long.parseLong(productDTO.getCategory()));
        this.productInfo = new ProductInfo(Long.parseLong(productDTO.getProductInfo()));
        this.customer = new Customer(Long.parseLong(productDTO.getCustomer()));
    }
}
