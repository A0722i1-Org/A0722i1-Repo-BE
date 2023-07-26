package com.example.medicalsupplieswebsite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String phone;

    private boolean gender;

    private Date dateOfBirth;

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
}
