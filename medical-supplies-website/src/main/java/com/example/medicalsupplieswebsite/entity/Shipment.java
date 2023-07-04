package com.example.medicalsupplieswebsite.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;
    private String invoceCode;
    private String note;
    private Date dateOfCreate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipment_type_id")
    private ShipmentType shipmentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private Set<ShipmentDetail> shipmentDetails = new LinkedHashSet<>();

}
