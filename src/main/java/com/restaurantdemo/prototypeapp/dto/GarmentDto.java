package com.restaurantdemo.prototypeapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarmentDto {
    private Long id;
    private String garmentName;
    private String imageUrl;
    private int price;
    private Long storeId;
    private int promotion;
    private int afterPromotionPrice;
    private int garmentType;
    private String buyUrl;
}
