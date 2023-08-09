package com.example.medicalsupplieswebsite.dto;

import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Cart;
import com.example.medicalsupplieswebsite.entity.CustomerType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
@Data
public class CustomerInfo {
    /** HieuLD
     *
     */
    private Long customerId;

    private String customerCode;

    @NotBlank(message = "Vui lòng nhập họ và tên")
    @Pattern(regexp = "^(?:[A-Z][a-zÀ-ỹ]*(?: [A-Z][a-zÀ-ỹ]*)+)$",message = "Họ và tên chưa đúng định dạng")
    @Length(min = 3,max = 50,message = "Họ và tên phải chứa ít nhất 3 kí tự và tối đa 50 kí tự")
    private String name;

    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @Pattern(regexp = "^(09|08)\\d{8}$",message = "số điện thoại chỉ được phép 10 số và bắt đầu 09 hoặc 08")
    private String phone;

    @NotNull(message = "Vui lòng chọn giới tính")
    private boolean gender;

    @NotNull(message = "Vui lòng nhập ngày sinh")
    private Date dateOfBirth;

    @NotBlank(message = "Vui lòng nhập email")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@gmail.com+$",message = "Email không đúng định dạng, vui lòng nhập lại. Ex: tên_email@gmail.com")
    @Length(min = 6,max = 30,message = "Tên email chỉ được phép chứa từ 6 đến 30 kí tự")
    private String email;

    @NotBlank(message = "Hộ chiếu/CMND không được để trống")
    @Pattern(regexp = "^\\d{12}$",message = "Hộ chiếu/CMND phải chứa 12 số")
    private String idCard;

    @NotBlank(message = "Vui lòng nhập địa chỉ")
    @Pattern(regexp = "^[^!@#$%^&*()_+<>?'\"{}\\`~|/\\\\]+$",message = "Địa chỉ không được chứa các kí tự đặc biệt")
    @Length(min = 5,max = 100,message = "Địa chỉ phải có ít nhất 5 và tối đa 100 kí tự")
    private String customerAddress;

    @NotNull(message = "Vui lòng chọn ảnh đại diện")
    private String customerImg;

    @NotNull(message = "Vui lòng chọn loại khách hàng")
    private CustomerType customerType;

    private Cart cart;
    private Account account;
    private boolean enable;



    public CustomerInfo() {
    }

    public CustomerInfo( String customerCode, String name, String phone, boolean gender,
                         Date dateOfBirth, String email, String idCard, String customerAddress,
                         String customerImg, CustomerType customerType, Cart cart,
                         Account account, boolean enable) {
        this.customerCode = customerCode;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.idCard = idCard;
        this.customerAddress = customerAddress;
        this.customerImg = customerImg;
        this.customerType = customerType;
        this.cart = cart;
        this.account = account;
        this.enable = enable;
    }


    public void validate(Object target, Errors errors) {
        CustomerInfo customerInfo = (CustomerInfo) target;
        if (!(customerInfo.dateOfBirth == null)) {
            LocalDate today = LocalDate.now();
            LocalDate minAgeDate = today.minusYears(12);
            LocalDate maxAgeDate = today.minusYears(90);
            if (customerInfo.dateOfBirth.toLocalDate().isAfter(minAgeDate)) {
                errors.rejectValue("dateOfBirth", "", "chưa đủ 12 tuổi");
            }
            if (customerInfo.dateOfBirth.toLocalDate().isBefore(maxAgeDate)) {
                errors.rejectValue("dateOfBirth", "", "lớn hơn 90 tuổi");
            }
        }
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerImg() {
        return customerImg;
    }

    public void setCustomerImg(String customerImg) {
        this.customerImg = customerImg;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
