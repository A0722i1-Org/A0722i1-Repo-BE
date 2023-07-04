package com.example.medicalsupplieswebsite.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String phone;
    private boolean gender;
    private Date dateOfBirth;
    private String idCard;
    private String customerAddress;
    private String customerImg;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Shipment> shipments = new LinkedHashSet<>();

}
