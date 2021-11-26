package com.restaurantdemo.prototypeapp.repository;



import com.restaurantdemo.prototypeapp.model.BrandStore;
import com.restaurantdemo.prototypeapp.model.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarmentRepository extends JpaRepository<Garment, Long> {
    List<Garment> findByStore(BrandStore store);
    List<Garment> findAllByGarmentType(Integer garmentType);
}
