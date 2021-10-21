package com.restaurantdemo.prototypeapp;

import com.restaurantdemo.prototypeapp.model.Restaurant;
import com.restaurantdemo.prototypeapp.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PrototypeappApplicationTests {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void testCreateRestaurant() {
        String restaurantName = "RestFood";
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantName);
        restaurant.setImageUrl("Some image rest");
        restaurant.setRestaurantId(100L);
        restaurant.setLocation("Some location rest");
        restaurantRepository.save(restaurant);
        assertNotNull(restaurantRepository.findByRestaurantName(restaurantName).get());
    }

    @Test
    public void testGetAll() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        assertThat(restaurantList).size().isGreaterThan(0);
    }

    @Test
    public void testSingleRestaurant() {
        Optional<Restaurant> restaurant = restaurantRepository.findById(5L);
        assertEquals("RestFood", restaurant.get().getRestaurantName());
    }

    @Test
    public void testUpdate() {
        Optional<Restaurant> restaurant = restaurantRepository.findById(5L);
        restaurant.get().setRestaurantName("NewRestFood");
        restaurantRepository.save(restaurant.get());
        assertNotEquals("RestFood", restaurant.get().getRestaurantName());
    }

    @Test
    public void testDelete() {
        restaurantRepository.deleteById(4L);
        assertThat(restaurantRepository.existsById(4L)).isFalse();
    }


}
