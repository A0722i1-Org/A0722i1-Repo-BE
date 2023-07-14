package com.example.medicalsupplieswebsite.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long employeeId;
//    private String employeeName;
//    private boolean gender;
//    private Date dateOfBirth;
//    private String employeeAddress;
//    private String employeeImg;
//    private boolean isEnable;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "position_id")
//    private Position position;
    private Long id;

    private String employeeCode;

    private String name;

    private String email;

    private String phone;

    private String address;

    private Integer gender;

    private String idCard;

    private int salary;

    private LocalDate dateOfBirth;

    private String avatar;

    private Boolean isEnable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee(Long id, String employeeCode, String name, String email, String phone, String address, Integer gender, String idCard, int salary, LocalDate dateOfBirth, String avatar, Boolean isEnable, Account account, Position position) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.idCard = idCard;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.avatar = avatar;
        this.isEnable = isEnable;
        this.account = account;
        this.position = position;
    }

    public Employee(Long id, String employeeCode, String name, String email, String phone, String address, Integer gender, String idCard, LocalDate dateOfBirth, String avatar, boolean isEnable, Position position) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.idCard = idCard;
        this.dateOfBirth = dateOfBirth;
        this.avatar = avatar;
        this.isEnable = isEnable;
        this.position = position;
    }
}
