package com.restaurantdemo.prototypeapp.controller;


import com.restaurantdemo.prototypeapp.dto.GarmentDto;
import com.restaurantdemo.prototypeapp.service.GarmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/garment")
@AllArgsConstructor
public class GarmentController {
    private final GarmentService garmentService;

    @PostMapping
    public ResponseEntity<Void> createGarment(@RequestBody GarmentDto garmentDto) {
        garmentService.save(garmentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GarmentDto>> getAllGarments() {
        return ResponseEntity.status(OK).body(garmentService.getAllGarments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarmentDto> getGarmentById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(garmentService.getGarmentById(id));
    }

    @GetMapping("/by-menu/{storeId}")
    public ResponseEntity<List<GarmentDto>> getAllGarmentsForStore(@PathVariable Long storeId) {
        return ResponseEntity.status(OK).body(garmentService.getAllGarmentsForStore(storeId));
    }

    @GetMapping("/by-productType/{productType}")
    public ResponseEntity<List<GarmentDto>> getAllGarmentsByProductType(@PathVariable Integer productType) {
        return ResponseEntity.status(OK).body(garmentService.getAllGarmentsForGarmentType(productType));
    }
}
