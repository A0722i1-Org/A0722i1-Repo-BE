package com.example.medicalsupplieswebsite.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;

    @Column(name = "info_introduction", length = 2000)
    private String infoIntroduction;

    @Column(name = "info_description", length = 2000)
    private String infoDescription;

    public ProductInfo(Long infoId) {
        this.infoId = infoId;
    }
}
