package com.restaurantdemo.prototypeapp;

import com.restaurantdemo.prototypeapp.model.BrandStore;
import com.restaurantdemo.prototypeapp.repository.BrandStoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PrototypeappApplicationTests {
    @Autowired
    private BrandStoreRepository brandStoreRepository;

    @Test
    public void testCreateStore() {
        String storeName = "Zara2";
        BrandStore store = new BrandStore();
        store.setStoreName(storeName);
        store.setImageUrl("Some clothes");
        store.setStoreId(100L);
        store.setLocation("Some location rest endpoint");
        brandStoreRepository.save(store);
        assertNotNull(brandStoreRepository.findByStoreName(storeName).get());
    }

    @Test
    public void testGetAll() {
        List<BrandStore> storeList = brandStoreRepository.findAll();
        assertThat(storeList).size().isGreaterThan(0);
    }

    @Test
    public void testSingleStore() {
        Optional<BrandStore> store = brandStoreRepository.findById(5L);
        assertEquals("RestFood", store.get().getStoreName());
    }

    @Test
    public void testUpdate() {
        Optional<BrandStore> store = brandStoreRepository.findById(5L);
        store.get().setStoreName("NewRestFood");
        brandStoreRepository.save(store.get());
        assertNotEquals("RestFood", store.get().getStoreName());
    }

    @Test
    public void testDelete() {
        brandStoreRepository.deleteById(4L);
        assertThat(brandStoreRepository.existsById(4L)).isFalse();
    }


}
