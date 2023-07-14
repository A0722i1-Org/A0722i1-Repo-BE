package com.example.medicalsupplieswebsite.dto;

import com.example.medicalsupplieswebsite.entity.Position;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class EmployeeInfo {
    private Long id;

    private String employeeCode;

    @NotBlank(message = "Vui lòng nhập họ tên")
    @Pattern(regexp = "^(?:[A-Z][a-zÀ-ỹ]*(?: [A-Z][a-zÀ-ỹ]*)+)$",message = "Họ và tên chưa đúng định dạng")
    @Length(min = 3,max = 50,message = "Họ và tên phải chứa ít nhất 3 kí tự và tối đa 50 kí tự")
    private String name;

    @NotBlank(message = "Vui lòng nhập email")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@gmail.com+$",message = "Email không đúng định dạng, vui lòng nhập lại. Ex: tên_email@gmail.com")
    @Length(min = 6,max = 30,message = "Tên email chỉ được phép chứa từ 6 đến 30 kí tự")
    private String email;

    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @Pattern(regexp = "^(09|08)\\d{8}$",message = "số điện thoại chỉ được phép 10 số và bắt đầu 09 hoặc 08")
    private String phone;

    @NotBlank(message = "Vui lòng nhập địa chỉ")
    @Pattern(regexp = "^[^!@#$%^&*()_+<>?'\"{}\\`~|/\\\\]+$",message = "Địa chỉ không được chứa các kí tự đặc biệt")
    @Length(min = 5,max = 100,message = "Địa chỉ phải có ít nhất 5 và tối đa 100 kí tự")
    private String address;

    @NotNull(message = "Vui lòng chọn giới tính")
    private Integer gender;

    @NotBlank(message = "Hộ chiếu/CMND không được để trống")
    @Pattern(regexp = "^\\d{12}$",message = "Hộ chiếu/CMND phải chứa 12 số")
    private String idCard;

    @NotNull(message = "Vui lòng nhập ngày sinh")
    private LocalDate dateOfBirth;

    @NotNull(message = "Vui lòng chọn chức vụ")
    private Position position;

    @NotNull(message = "Vui lòng chọn ảnh đại diện")
    private String avatar;

    public EmployeeInfo() {
    }

    public EmployeeInfo(Long id, String employeeCode, String name, String email, String phone, String address, Integer gender, String idCard, LocalDate dateOfBirth, Position position, String avatar) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.idCard = idCard;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void validate(Object target, Errors errors) {
        EmployeeInfo employeeInfo = (EmployeeInfo) target;
        if (!(employeeInfo.dateOfBirth == null)) {
            LocalDate today = LocalDate.now();
            LocalDate minAgeDate = today.minusYears(23);
            LocalDate maxAgeDate = today.minusYears(50);
            if (employeeInfo.dateOfBirth.isAfter(minAgeDate)) {
                errors.rejectValue("dateOfBirth", "", "chưa đủ 23 tuổi");
            }
            if (employeeInfo.dateOfBirth.isBefore(maxAgeDate)) {
                errors.rejectValue("dateOfBirth", "", "lớn hơn 50 tuổi");
            }
        }
    }
}
