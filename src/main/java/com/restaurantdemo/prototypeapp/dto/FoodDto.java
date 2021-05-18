package com.restaurantdemo.prototypeapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private Long id;
    private String foodName;
    private String imageUrl;
    private int price;
    private int quantity;
    private Long restaurantId;
}
