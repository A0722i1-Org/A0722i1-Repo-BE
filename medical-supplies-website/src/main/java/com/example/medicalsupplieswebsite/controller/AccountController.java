package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Employee;

import com.example.medicalsupplieswebsite.dto.ChangePasswordDto;
import com.example.medicalsupplieswebsite.security.userprinciple.UserDetailService;
import com.example.medicalsupplieswebsite.service.impl.AccountService;
import com.example.medicalsupplieswebsite.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;
    private final EmployeeService employeeService;

    public AccountController(AccountService accountService, EmployeeService employeeService) {
        this.accountService = accountService;
        this.employeeService = employeeService;
    }

/*ThienTDV thêm Tài khoản và setRole cho tài khoản*/
    @PostMapping("/addAccount")
    public ResponseEntity<?> addAccountForEmployee(@Valid @RequestBody Account account, BindingResult bindingResult, @RequestParam Long roleId) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    error -> {
                        String fieldName = error.getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                    });
            return ResponseEntity.badRequest().body(errors);
        }
        // Lưu tài khoản
        Account savedAccount = accountService.addAccount(account);
        account.setEnable(true);

        // Thiết lập vai trò cho tài khoản
        accountService.setRoleForAccount(savedAccount.getAccountId(), roleId);

        return new ResponseEntity<>(HttpStatus.CREATED);
      
    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * A0722I1-NhanTQ
     */

    @PatchMapping("change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(changePasswordDto.getUsername(), changePasswordDto.getPresentPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPass = encoder.encode(changePasswordDto.getConfirmPassword());

        accountService.changePassword(username, newPass);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
