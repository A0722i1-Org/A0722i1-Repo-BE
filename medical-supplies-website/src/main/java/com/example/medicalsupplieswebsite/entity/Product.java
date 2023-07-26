package com.example.medicalsupplieswebsite.entity;

import com.example.medicalsupplieswebsite.dto.ProductCreateDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;


    private Integer productPrice;

    private Integer productQuantity;

    private String productImg;

    @GeneratedValue(generator = "person-generator")
    @GenericGenerator(name = "person-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "VT"),
            strategy = "com.example.medicalsupplieswebsite.utils.PersonAutoGenerator")
    @Column(length = 45)
    private String productCode;

    private Date expireDate;

    private boolean isEnable;


    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "categoryId")
    private Category category;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "product_info_id",nullable = false,referencedColumnName = "infoId")
    private ProductInfo productInfo;

    @ManyToOne
    @JsonManagedReference
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
    public Product(ProductCreateDTO productCreateDTO){
        this.productName = productCreateDTO.getProductName();
        this.productPrice = productCreateDTO.getProductPrice();
        this.productQuantity = productCreateDTO.getProductQuantity();
        this.productImg = productCreateDTO.getProductImg();
        this.productCode = productCreateDTO.getProductCode();
        this.expireDate = productCreateDTO.getExpireDate();
        this.isEnable = false;
        this.category = new Category(Long.parseLong(productCreateDTO.getCategory()));
        this.productInfo = new ProductInfo(Long.parseLong(productCreateDTO.getProductInfo()));
        this.customer = new Customer(Long.parseLong(productCreateDTO.getCustomer()));
    }
}
