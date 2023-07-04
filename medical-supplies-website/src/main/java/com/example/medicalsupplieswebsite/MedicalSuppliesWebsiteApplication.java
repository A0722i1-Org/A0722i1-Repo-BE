package com.example.medicalsupplieswebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class MedicalSuppliesWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalSuppliesWebsiteApplication.class, args);
	}

}
