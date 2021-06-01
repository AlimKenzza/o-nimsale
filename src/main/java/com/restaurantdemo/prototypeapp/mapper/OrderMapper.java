package com.restaurantdemo.prototypeapp.mapper;


import com.restaurantdemo.prototypeapp.dto.OrderDto;
import com.restaurantdemo.prototypeapp.model.Order;
import com.restaurantdemo.prototypeapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "userId", expression = "java(order.getUser().getUserId())")
    OrderDto mapOrderToDto(Order order);

    Order map(OrderDto orderDto, User user);
}
