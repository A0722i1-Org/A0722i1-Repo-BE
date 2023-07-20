package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ChangePasswordDto;
import com.example.medicalsupplieswebsite.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

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
