package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ChangePasswordDto;
import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.entity.Role;
import com.example.medicalsupplieswebsite.service.impl.AccountService;
import com.example.medicalsupplieswebsite.service.impl.EmployeeService;
import com.example.medicalsupplieswebsite.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/account")

public class AccountController {
    private final AccountService accountService;
    private final EmployeeService employeeService;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AccountController(AccountService accountService, EmployeeService employeeService, RoleService roleService, AuthenticationManager authenticationManager) {
        this.accountService = accountService;
        this.employeeService = employeeService;
        this.roleService = roleService;
        this.authenticationManager = authenticationManager;
    }

    /*ThienTDV thêm Tài khoản và setRole cho tài khoản*/
    @PostMapping("/addAccount")
    public ResponseEntity<?> addAccount(@Valid @RequestBody Account account, BindingResult bindingResult, @RequestParam Long roleId) {
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
        // Kiểm tra xem roleId có tồn tại trong danh sách các roles hợp lệ không
        Role role = roleService.findById(roleId);
        if (role == null) {
            return ResponseEntity.badRequest().body("Invalid roleId");
        }
        // Lưu tài khoản
        Account savedAccount = accountService.addAccount(account);
        Long AccountId = savedAccount.getAccountId();
        // Thiết lập vai trò cho tài khoản
        accountService.setRoleForAccount(AccountId, roleId);
        return ResponseEntity.ok(savedAccount);
    }


    //Hiển thị thông tin role
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    /**
     * A0722I1-NhanTQ
     */

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(changePasswordDto.getUsername(), changePasswordDto.getPresentPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPass = encoder.encode(changePasswordDto.getConfirmPassword());
        accountService.changePassword(username, newPass);
        return new ResponseEntity<>(new ChangePasswordDto(
                changePasswordDto.getUsername(),
                "", ""), HttpStatus.OK);
    }
}

