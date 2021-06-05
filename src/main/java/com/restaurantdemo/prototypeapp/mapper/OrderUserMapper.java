package com.restaurantdemo.prototypeapp.mapper;


import com.restaurantdemo.prototypeapp.dto.OrderUserDto;
import com.restaurantdemo.prototypeapp.model.Item;
import com.restaurantdemo.prototypeapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface OrderUserMapper {

//    @Mapping(target = "username", expression = "java(item.getOrder().getUser().getUsername())")
    OrderUserDto mapOrderUserToDto(Item item);
}
