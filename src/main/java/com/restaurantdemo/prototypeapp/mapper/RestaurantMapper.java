package com.restaurantdemo.prototypeapp.mapper;

import com.restaurantdemo.prototypeapp.dto.RestaurantDto;
import com.restaurantdemo.prototypeapp.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto mapRestaurantToDto(Restaurant restaurant);

    Restaurant map(RestaurantDto restaurantDto);
}
