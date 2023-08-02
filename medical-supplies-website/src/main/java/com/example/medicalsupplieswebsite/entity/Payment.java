package com.example.medicalsupplieswebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartId;
    private int totalAmount;
    @OneToMany
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();
    private String secureHash;
    private boolean isPaid;
}