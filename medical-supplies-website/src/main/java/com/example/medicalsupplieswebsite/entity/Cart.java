package com.example.medicalsupplieswebsite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String receiverName;
    private String receiverAddress;
    private String receiverEmail;

    @JsonBackReference
    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Customer customer;

}
