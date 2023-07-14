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
    private Long employeeId;

    private String employeeCode;

    private String employeeName;

    private String email;

    private String phone;

    private String employeeAddress;

    private Integer gender;

    private String idCard;

    private int salary;

    private LocalDate dateOfBirth;

    private String employeeImg;

    private Boolean isEnable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee(Long employeeId, String employeeCode, String employeeName, String email, String phone, String employeeAddress, Integer gender, String idCard, int salary, LocalDate dateOfBirth, String avatar, Boolean isEnable, Account account, Position position) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.employeeAddress = employeeAddress;
        this.gender = gender;
        this.idCard = idCard;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.employeeImg = avatar;
        this.isEnable = isEnable;
        this.account = account;
        this.position = position;
    }

    public Employee(Long employeeId, String employeeCode, String employeeName, String email, String phone, String employeeAddress, Integer gender, String idCard, LocalDate dateOfBirth, String avatar, boolean isEnable, Position position) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.employeeAddress = employeeAddress;
        this.gender = gender;
        this.idCard = idCard;
        this.dateOfBirth = dateOfBirth;
        this.employeeImg = avatar;
        this.isEnable = isEnable;
        this.position = position;
    }
}
