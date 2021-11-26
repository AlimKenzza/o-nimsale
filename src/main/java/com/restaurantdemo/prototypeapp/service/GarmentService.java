package com.restaurantdemo.prototypeapp.service;


import com.restaurantdemo.prototypeapp.dto.GarmentDto;
import com.restaurantdemo.prototypeapp.exceptions.RestaurantNotFoundException;
import com.restaurantdemo.prototypeapp.exceptions.SpringAppException;
import com.restaurantdemo.prototypeapp.mapper.GarmentMapper;
import com.restaurantdemo.prototypeapp.model.BrandStore;
import com.restaurantdemo.prototypeapp.model.Garment;
import com.restaurantdemo.prototypeapp.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Transactional
public class GarmentService {
    private final GarmentRepository garmentRepository;
    private final GarmentMapper garmentMapper;
    private final BrandStoreRepository brandStoreRepository;


    public void save(GarmentDto garmentDto) {
        BrandStore store = brandStoreRepository.findById(garmentDto.getStoreId())
                .orElseThrow(() -> new RestaurantNotFoundException(garmentDto.getStoreId().toString()));
        Garment garment = garmentMapper.map(garmentDto, store);
        garmentRepository.save(garment);
    }

    @Transactional(readOnly = true)
    public List<GarmentDto> getAllGarments() {
        return garmentRepository.findAll()
                .stream()
                .map(garmentMapper:: mapGarmentToDto)
                .collect(toList());
    }
    public GarmentDto getGarmentById(Long id) {
        Garment garment = garmentRepository.findById(id)
                .orElseThrow(() -> new SpringAppException("No garment found with ID - " + id));
        return garmentMapper.mapGarmentToDto(garment);
    }


    public List<GarmentDto> getAllGarmentsForStore(Long storeId) {
        BrandStore store = brandStoreRepository.findById(storeId).orElseThrow(() -> new RestaurantNotFoundException(storeId.toString()));
        return garmentRepository.findByStore(store)
                .stream().map(garmentMapper::mapGarmentToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<GarmentDto> getAllGarmentsForGarmentType(Integer garmentType) {
        return  garmentRepository.findAllByGarmentType(garmentType)
                .stream()
                .map(garmentMapper::mapGarmentToDto)
                .collect(toList());
    }
}
