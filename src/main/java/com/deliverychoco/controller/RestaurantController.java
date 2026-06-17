package com.deliverychoco.controller;

import com.deliverychoco.entity.Restaurant;
import com.deliverychoco.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.deliverychoco.dto.CreateRestaurantRequest;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(
            RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant createRestaurant(
            @Valid
            @RequestBody
            CreateRestaurantRequest request) {

        return restaurantService.createRestaurant(
                request);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {

        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(
            @PathVariable Long id) {

        return restaurantService
                .getRestaurantById(id);
    }
}