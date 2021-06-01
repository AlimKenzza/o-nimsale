package com.restaurantdemo.prototypeapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "food_id", nullable = false)
//    private Food food;
    private int quantity;
    private int price;
    private Instant createdDate;
    private String name;
    private String imageUrl;
    private String username;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}
