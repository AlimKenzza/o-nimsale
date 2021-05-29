package com.restaurantdemo.prototypeapp.mapper;


import com.restaurantdemo.prototypeapp.dto.FoodDto;
import com.restaurantdemo.prototypeapp.model.Food;
import com.restaurantdemo.prototypeapp.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    @Mapping(target = "restaurantId", expression = "java(food.getRestaurant().getRestaurantId())")
    FoodDto mapFoodToDto(Food food);

    @Mapping(target = "id", source = "foodDto.id")
    @Mapping(target = "imageUrl", source = "foodDto.imageUrl")
    Food map(FoodDto foodDto, Restaurant restaurant);
}
