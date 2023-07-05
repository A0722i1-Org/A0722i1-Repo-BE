package com.example.medicalsupplieswebsite.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String receiverName;
    private String receiverCity;
    private String receiverAddress;
    private String receiverEmail;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Customer customer;

    public void clearAllItems() {
        this.cartDetails.clear();
    }
}
