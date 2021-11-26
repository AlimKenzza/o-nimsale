package com.restaurantdemo.prototypeapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "garment")
@AllArgsConstructor
@NoArgsConstructor
public class Garment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String garmentName;
    private int price;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private BrandStore store;
    private String imageUrl;
    private Integer promotion;
    private Integer afterPromotionPrice;
    private Integer garmentType;
    private String buyUrl;
//    @OneToOne(fetch = FetchType.LAZY,
//            cascade =  CascadeType.ALL,
//            mappedBy = "food")
//    private Item item;
}
