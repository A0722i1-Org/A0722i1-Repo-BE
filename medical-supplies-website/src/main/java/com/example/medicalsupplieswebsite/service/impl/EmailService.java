package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.EmailDetails;
import com.example.medicalsupplieswebsite.entity.Cart;
import com.example.medicalsupplieswebsite.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    //Author: NhatLH

    private final JavaMailSender javaMailSender;

    @Autowired
    EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String sender;
    public String sendSimpleMail(EmailDetails details) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setSubject(details.getSubject());
            mailMessage.setText(details.getBody());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    @Async
    public void emailProcess(Cart cart, long totalAmount) {
        String recipient = cart.getReceiverEmail();
        String subject = "Email xác nhận đơn hàng";
        String body = "Xin chào quý khách: " + cart.getReceiverName() + ",\nĐơn hàng của quý khách đã được tiếp nhận.\nVà dự kiến sẽ được giao đến địa chỉ: " + cart.getReceiverAddress() + " trong vòng 3-5 ngày.\nTổng giá trị thanh toán là: " + totalAmount + " VND.\nXin cảm ơn quý khách đã tin dùng sản phẩm của công ty chúng tôi.\nA0722I1 Co.Ltd";
        EmailDetails emailDetails = new EmailDetails(recipient, subject, body);
        this.sendSimpleMail(emailDetails);
    }
}
