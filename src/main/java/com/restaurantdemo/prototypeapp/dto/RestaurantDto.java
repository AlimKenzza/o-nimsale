package com.restaurantdemo.prototypeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private Long restaurantId;
    private String restaurantName;
    private String location;
    private String imageUrl;
}
