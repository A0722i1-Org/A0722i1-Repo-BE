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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private boolean gender;
    private Date dateOfBirth;
    private String employeeAddress;
    private String employeeImg;
    private int salary;
    private boolean isEnable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Receipt> receipts = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Shipment> shipments = new LinkedHashSet<>();

}
