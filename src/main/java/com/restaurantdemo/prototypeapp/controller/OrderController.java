package com.restaurantdemo.prototypeapp.controller;

import com.restaurantdemo.prototypeapp.dto.OrderUserDto;
import com.restaurantdemo.prototypeapp.service.OrderItemService;
import com.restaurantdemo.prototypeapp.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderItemService orderItemService;
    private final OrderService orderService;
}
