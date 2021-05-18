package com.restaurantdemo.prototypeapp.controller;

import com.restaurantdemo.prototypeapp.dto.RestaurantDto;
import com.restaurantdemo.prototypeapp.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Void> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.save(restaurantDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getRestaurantById(id));
    }
}
