package com.example.medicalsupplieswebsite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerCode;
    private String name;
    private String phone;
    private boolean gender;
    private Date dateOfBirth;
    private String email;
    private String idCard;
    private String customerAddress;
    private String customerImg;
    private boolean isEnable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_type_id")
    @JsonBackReference
    private CustomerType customerType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

    public Customer(Long customerId) {
        this.customerId = customerId;
    }
    public Customer(Long customerId, String customerCode, String name, String phone, boolean gender, Date dateOfBirth, String email, String idCard, String customerAddress, String customerImg, boolean isEnable, CustomerType customerType, Cart cart, Account account) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.idCard = idCard;
        this.customerAddress = customerAddress;
        this.customerImg = customerImg;
        this.isEnable = isEnable;
        this.customerType = customerType;
        this.cart = cart;
        this.account = account;
    }

    public Customer(Long customerId, String customerCode, String name, String phone, boolean gender, Date dateOfBirth, String email, String idCard, String customerAddress, String customerImg, boolean isEnable, CustomerType customerType) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.idCard = idCard;
        this.customerAddress = customerAddress;
        this.customerImg = customerImg;
        this.isEnable = isEnable;
        this.customerType = customerType;
    }
}
