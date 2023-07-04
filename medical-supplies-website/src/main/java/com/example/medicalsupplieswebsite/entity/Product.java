package com.example.medicalsupplieswebsite.entity;

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
    private int productPrice;
    private int productQuantity;
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ReceiptDetail> receiptDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ShipmentDetail> shipmentDetails = new LinkedHashSet<>();

}
