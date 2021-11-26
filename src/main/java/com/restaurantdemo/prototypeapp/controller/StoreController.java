package com.restaurantdemo.prototypeapp.controller;

import com.restaurantdemo.prototypeapp.dto.StoreDto;
import com.restaurantdemo.prototypeapp.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
@AllArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Void> createStore(@RequestBody StoreDto storeDto) {
        storeService.save(storeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StoreDto>> getAllStores() {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getAllStores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> getStoreById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getStoreById(id));
    }
}
