package com.restaurantdemo.prototypeapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store")
public class BrandStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String storeName;
    private String location;
    private String imageUrl;
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Garment> garmentList;
}
