package com.restaurantdemo.prototypeapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUserDto {
    private int orderId;
    private String username;
    private String name;
    private String imageUrl;
    private int quantity;
    private int price;
}
