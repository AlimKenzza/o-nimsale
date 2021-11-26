package com.restaurantdemo.prototypeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {
    private Long storeId;
    private String storeName;
    private String location;
    private String imageUrl;
}
