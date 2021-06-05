package com.restaurantdemo.prototypeapp.repository;

import com.restaurantdemo.prototypeapp.model.Item;
import com.restaurantdemo.prototypeapp.model.Order;
import com.restaurantdemo.prototypeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllItemsByOrder(Order order);
    void deleteOrderById(Long id);
    List<Item> findByUsername(String username);
}
