package com.restaurantdemo.prototypeapp.repository;


import com.restaurantdemo.prototypeapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    Optional<Restaurant> findRestaurant(String restaurantName);
     Optional<Restaurant> findByRestaurantName(String restaurantName);
}
