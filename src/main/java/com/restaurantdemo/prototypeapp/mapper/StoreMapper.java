package com.restaurantdemo.prototypeapp.mapper;

import com.restaurantdemo.prototypeapp.dto.StoreDto;
import com.restaurantdemo.prototypeapp.model.BrandStore;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    StoreDto mapStoreToDto(BrandStore store);

    BrandStore map(StoreDto storeDto);
}
