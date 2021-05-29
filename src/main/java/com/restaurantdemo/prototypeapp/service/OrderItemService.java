package com.restaurantdemo.prototypeapp.service;


import com.restaurantdemo.prototypeapp.dto.FoodDto;
import com.restaurantdemo.prototypeapp.dto.OrderItemDto;
import com.restaurantdemo.prototypeapp.exceptions.FoodNotFoundException;
import com.restaurantdemo.prototypeapp.exceptions.OrderNotFoundException;
import com.restaurantdemo.prototypeapp.mapper.ItemMapper;
import com.restaurantdemo.prototypeapp.model.Food;
import com.restaurantdemo.prototypeapp.model.Item;
import com.restaurantdemo.prototypeapp.model.Order;
import com.restaurantdemo.prototypeapp.repository.FoodRepository;
import com.restaurantdemo.prototypeapp.repository.ItemRepository;
import com.restaurantdemo.prototypeapp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final ItemRepository itemRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;
    private final ItemMapper itemMapper;

    public void save(OrderItemDto orderItemDto) {
        Order order = orderRepository.findById(orderItemDto.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(orderItemDto.getOrderId().toString()));
        Item item = itemMapper.map(orderItemDto, order);
        itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public List<OrderItemDto> getAllItemsForOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId.toString()));
        return itemRepository.findAllItemsByOrder(order)
                .stream()
                .map(itemMapper:: mapItemToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<OrderItemDto> getAllOrders() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper:: mapItemToDto)
                .collect(toList());
    }

    @Transactional
    public void deleteOrder(Long id){
        itemRepository.deleteOrderById(id);
    }

}
