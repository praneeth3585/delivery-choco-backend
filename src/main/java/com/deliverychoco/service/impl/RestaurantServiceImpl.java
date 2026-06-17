package com.deliverychoco.service.impl;

import com.deliverychoco.entity.Restaurant;
import com.deliverychoco.exception.ResourceNotFoundException;
import com.deliverychoco.repository.RestaurantRepository;
import com.deliverychoco.service.RestaurantService;
import org.springframework.stereotype.Service;
import com.deliverychoco.dto.CreateRestaurantRequest;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(
            RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant createRestaurant(
            CreateRestaurantRequest request) {

        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .cuisine(request.getCuisine())
                .build();

        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {

        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {

        return restaurantRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Restaurant not found"));
    }
}