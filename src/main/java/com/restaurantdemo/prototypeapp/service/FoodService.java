package com.restaurantdemo.prototypeapp.service;


import com.restaurantdemo.prototypeapp.dto.FoodDto;
import com.restaurantdemo.prototypeapp.exceptions.RestaurantNotFoundException;
import com.restaurantdemo.prototypeapp.exceptions.SpringAppException;
import com.restaurantdemo.prototypeapp.mapper.FoodMapper;
import com.restaurantdemo.prototypeapp.model.Food;
import com.restaurantdemo.prototypeapp.model.Restaurant;
import com.restaurantdemo.prototypeapp.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Transactional
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;
    private final RestaurantRepository restaurantRepository;


    public void save(FoodDto foodDto) {
        Restaurant restaurant = restaurantRepository.findById(foodDto.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException(foodDto.getRestaurantId().toString()));
        Food food = foodMapper.map(foodDto, restaurant);
        foodRepository.save(food);
    }

    @Transactional(readOnly = true)
    public List<FoodDto> getAllFoods() {
        return foodRepository.findAll()
                .stream()
                .map(foodMapper:: mapFoodToDto)
                .collect(toList());
    }
    public FoodDto getFoodById(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new SpringAppException("No food found with ID - " + id));
        return foodMapper.mapFoodToDto(food);
    }


    public List<FoodDto> getAllFoodsForRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantNotFoundException(restaurantId.toString()));
        return foodRepository.findByRestaurant(restaurant)
                .stream().map(foodMapper::mapFoodToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<FoodDto> getAllFoodsForProductType(Integer productType) {
        return  foodRepository.findAllByProductType(productType)
                .stream()
                .map(foodMapper::mapFoodToDto)
                .collect(toList());
    }
}
