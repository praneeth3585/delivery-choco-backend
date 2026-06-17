package com.deliverychoco.repository;

import com.deliverychoco.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository
        extends JpaRepository<Restaurant, Long> {
}