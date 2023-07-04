package com.example.medicalsupplieswebsite.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Customer> customers = new LinkedHashSet<>();

}
