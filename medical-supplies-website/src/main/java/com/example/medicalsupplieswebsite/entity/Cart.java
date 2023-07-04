package com.example.medicalsupplieswebsite.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String receiverName;
    private String receiverCity;
    private String receiverAddress;
    private String receiverEmail;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();

}
