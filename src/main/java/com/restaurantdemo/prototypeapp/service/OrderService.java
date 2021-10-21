package com.restaurantdemo.prototypeapp.service;


import com.restaurantdemo.prototypeapp.dto.OrderDto;
import com.restaurantdemo.prototypeapp.exceptions.UserNotFoundException;
import com.restaurantdemo.prototypeapp.mapper.OrderMapper;
import com.restaurantdemo.prototypeapp.mapper.OrderUserMapper;
import com.restaurantdemo.prototypeapp.model.Order;
import com.restaurantdemo.prototypeapp.model.User;
import com.restaurantdemo.prototypeapp.repository.OrderRepository;
import com.restaurantdemo.prototypeapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;
    private final OrderUserMapper orderUserMapper;


    public void save(OrderDto orderDto) {
        User user = userRepository.findById(orderDto.getUserId()).orElseThrow(() -> new UserNotFoundException(orderDto.getUserId().toString()));
        Order order = orderMapper.map(orderDto, user);
        orderRepository.save(order);
    }

}
