package com.example.medicalsupplieswebsite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne()
    @JoinColumn(name = "product_info_id")
    private ProductInfo productInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
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

}
