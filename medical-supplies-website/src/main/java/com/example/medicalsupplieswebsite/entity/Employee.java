package com.example.medicalsupplieswebsite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private String employeeCode;

    private String employeeName;

    private String email;

    private String phone;

    private String employeeAddress;

    private Integer gender;

    private String idCard;

    private Integer salary;

    private Date dateOfBirth;

    private String employeeImg;

    private Boolean isEnable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee(Long employeeId, String employeeCode, String employeeName, String email, String phone, String employeeAddress, Integer gender, String idCard, Integer salary, LocalDate dateOfBirth, String employeeImg, Boolean isEnable, Account account, Position position) {
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
        this.employeeImg = employeeImg;
        this.isEnable = isEnable;
        this.account = account;
        this.position = position;
    }

    public Employee(Long employeeId, String employeeCode, String employeeName, String email, String phone, String employeeAddress, Integer gender, String idCard, LocalDate dateOfBirth, String employeeImg, boolean isEnable, Position position) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.employeeAddress = employeeAddress;
        this.gender = gender;
        this.idCard = idCard;
        this.dateOfBirth = dateOfBirth;
        this.employeeImg = employeeImg;
        this.isEnable = isEnable;
        this.position = position;
    }
}
