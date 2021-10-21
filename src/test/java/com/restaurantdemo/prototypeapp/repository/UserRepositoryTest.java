package com.restaurantdemo.prototypeapp.repository;

import com.restaurantdemo.prototypeapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void itShouldFindByUsername() {
        //given
        String username = "alimzhan";
        User user = new User();
        user.setUsername(username);
        user.setEnabled(false);
        user.setCreated(Instant.now());
        user.setPassword("master");
        user.setEmail("alimkz@gmail.com");
        userRepository.save(user);
        //when
        Optional<User> optionalUser = userRepository.findByUsername(username);
        //then

    }
}