package com.restaurantdemo.prototypeapp.mapper;


import com.restaurantdemo.prototypeapp.dto.GarmentDto;
import com.restaurantdemo.prototypeapp.model.BrandStore;
import com.restaurantdemo.prototypeapp.model.Garment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GarmentMapper {

    @Mapping(target = "storeId", expression = "java(garment.getStore().getStoreId())")
    GarmentDto mapGarmentToDto(Garment garment);

    @Mapping(target = "id", source = "garmentDto.id")
    @Mapping(target = "imageUrl", source = "garmentDto.imageUrl")
    Garment map(GarmentDto garmentDto, BrandStore store);
}
