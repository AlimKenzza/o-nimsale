package com.restaurantdemo.prototypeapp.controller;


import com.restaurantdemo.prototypeapp.dto.OrderItemDto;
import com.restaurantdemo.prototypeapp.dto.OrderUserDto;
import com.restaurantdemo.prototypeapp.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class ItemController {
    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody OrderItemDto orderItemDto) {
        orderItemService.save(orderItemDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAllOrders() {
        return ResponseEntity.status(OK).body(orderItemService.getAllOrders());
    }


    @GetMapping("/by-order/{orderId}")
    public ResponseEntity<List<OrderItemDto>> getAllItemsForOrder(@PathVariable Long orderId) {
        return ResponseEntity.status(OK).body(orderItemService.getAllItemsForOrder(orderId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        orderItemService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<List<OrderUserDto>> getAllItemsForUser(@PathVariable String username) {
        return ResponseEntity.status(OK).body(orderItemService.getAllFoodsForUser(username));
    }
}
