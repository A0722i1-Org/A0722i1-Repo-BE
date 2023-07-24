package com.example.medicalsupplieswebsite.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class EmployeeDTO {
    private String employeeImg;
    @NotBlank(message = "Vui lòng nhập họ và tên!")
    private String employeeName;
    private boolean gender;
    @NotNull(message = "Vui lòng nhập ngày tháng năm sinh!")

    private Date dateOfBirth;
    @NotBlank(message = "Vui lòng nhập địa chỉ!")

    private String employeeAddress;
    @NotBlank(message = "Vui lòng nhập số điện thoại!")

    private String phone;
    @Email(message = "Vui lòng nhập đúng định dạng!")
    private String email;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeImg, String employeeName, boolean gender, Date dateOfBirth, String employeeAddress, String phone, String email) {
        this.employeeImg = employeeImg;
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.employeeAddress = employeeAddress;
        this.phone = phone;
        this.email = email;
    }

    public String getEmployeeImg() {
        return employeeImg;
    }

    public void setEmployeeImg(String employeeImg) {
        this.employeeImg = employeeImg;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
