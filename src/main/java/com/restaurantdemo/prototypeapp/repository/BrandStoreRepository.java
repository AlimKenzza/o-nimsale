package com.restaurantdemo.prototypeapp.repository;



import com.restaurantdemo.prototypeapp.model.BrandStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandStoreRepository extends JpaRepository<BrandStore, Long> {
//    Optional<Restaurant> findRestaurant(String restaurantName);
     Optional<BrandStore> findByStoreName(String storeName);
}
