package com.restaurantdemo.prototypeapp.repository;


import com.restaurantdemo.prototypeapp.model.Food;
import com.restaurantdemo.prototypeapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurant(Restaurant restaurant);
}
