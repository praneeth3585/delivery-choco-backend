package com.deliverychoco.service;

import com.deliverychoco.dto.CreateRestaurantRequest;
import com.deliverychoco.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant createRestaurant(
            CreateRestaurantRequest request);

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(Long id);
}