package com.restaurantdemo.prototypeapp.mapper;


import com.restaurantdemo.prototypeapp.dto.OrderItemDto;
import com.restaurantdemo.prototypeapp.model.Item;
import com.restaurantdemo.prototypeapp.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", source = "order")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    Item map(OrderItemDto orderItemDto, Order order);


//    @Mapping(target = "name", expression = "java(item.getFood().getFoodName())")
//    @Mapping(target = "price", expression = "java(item.getFood().getPrice())")
//    @Mapping(target = "userName", expression = "java(item.getUser().getUsername())")
    @Mapping(target = "orderId", expression = "java(item.getOrder().getOrderId())")
//    @Mapping(target = "foodId", expression = "java(item.getFood().getId())")
    OrderItemDto mapItemToDto(Item item);
}
