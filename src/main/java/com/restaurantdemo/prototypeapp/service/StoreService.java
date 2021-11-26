package com.restaurantdemo.prototypeapp.service;


import com.restaurantdemo.prototypeapp.dto.StoreDto;
import com.restaurantdemo.prototypeapp.exceptions.SpringAppException;
import com.restaurantdemo.prototypeapp.mapper.StoreMapper;
import com.restaurantdemo.prototypeapp.model.BrandStore;
import com.restaurantdemo.prototypeapp.repository.BrandStoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class StoreService {
    private final BrandStoreRepository brandStoreRepository;
    private final StoreMapper storeMapper;


    public void save(StoreDto storeDto) {
        BrandStore store = storeMapper.map(storeDto);
        brandStoreRepository.save(store);
    }

    @Transactional(readOnly = true)
    public List<StoreDto> getAllStores() {
        return brandStoreRepository.findAll()
                .stream()
                .map(storeMapper:: mapStoreToDto)
                .collect(toList());
    }
    public StoreDto getStoreById(Long id) {
        BrandStore store = brandStoreRepository.findById(id)
                .orElseThrow(() -> new SpringAppException("No store found with ID - " + id));
        return storeMapper.mapStoreToDto(store);
    }
}
