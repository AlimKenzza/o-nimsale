package com.restaurantdemo.prototypeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PrototypeappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrototypeappApplication.class, args);
    }

}
