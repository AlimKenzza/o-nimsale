package com.restaurantdemo.prototypeapp.service;


import com.restaurantdemo.prototypeapp.dto.RestaurantDto;
import com.restaurantdemo.prototypeapp.exceptions.SpringAppException;
import com.restaurantdemo.prototypeapp.mapper.RestaurantMapper;
import com.restaurantdemo.prototypeapp.model.Restaurant;
import com.restaurantdemo.prototypeapp.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;


    public void save(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantMapper.map(restaurantDto);
        restaurantRepository.save(restaurant);
    }

    @Transactional(readOnly = true)
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper:: mapRestaurantToDto)
                .collect(toList());
    }
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new SpringAppException("No subreddit found with ID - " + id));
        return restaurantMapper.mapRestaurantToDto(restaurant);
    }
}
