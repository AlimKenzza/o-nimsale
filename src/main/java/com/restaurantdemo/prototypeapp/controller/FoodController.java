package com.restaurantdemo.prototypeapp.controller;


import com.restaurantdemo.prototypeapp.dto.FoodDto;
import com.restaurantdemo.prototypeapp.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/food")
@AllArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<Void> createFood(@RequestBody FoodDto foodDto) {
        foodService.save(foodDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodDto>> getAllFoods() {
        return ResponseEntity.status(OK).body(foodService.getAllFoods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDto> getFoodById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(foodService.getFoodById(id));
    }

    @GetMapping("/by-menu/{restaurantId}")
    public ResponseEntity<List<FoodDto>> getAllFoodsForMenu(@PathVariable Long restaurantId) {
        return ResponseEntity.status(OK).body(foodService.getAllFoodsForRestaurant(restaurantId));
    }

    @GetMapping("/by-productType/{productType}")
    public ResponseEntity<List<FoodDto>> getAllFoodsByProductType(@PathVariable Integer productType) {
        return ResponseEntity.status(OK).body(foodService.getAllFoodsForProductType(productType));
    }
}
