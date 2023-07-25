package com.example.medicalsupplieswebsite.service;

import com.example.medicalsupplieswebsite.dto.EmailDetails;

public interface IEmailService {
    //Author: NhatLH
    String sendSimpleMail(EmailDetails emailDetails);

}
