package com.deliverychoco.service.impl;

import com.deliverychoco.dto.CreateMenuItemRequest;
import com.deliverychoco.entity.MenuItem;
import com.deliverychoco.entity.Restaurant;
import com.deliverychoco.repository.MenuItemRepository;
import com.deliverychoco.repository.RestaurantRepository;
import com.deliverychoco.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItemServiceImpl(
            MenuItemRepository menuItemRepository,
            RestaurantRepository restaurantRepository) {

        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public MenuItem createMenuItem(CreateMenuItemRequest request) {

        Restaurant restaurant =
                restaurantRepository.findById(request.getRestaurantId())
                        .orElseThrow(() ->
                                new RuntimeException("Restaurant not found"));

        MenuItem menuItem = MenuItem.builder()
                .name(request.getName())
                .price(request.getPrice())
                .restaurant(restaurant)
                .build();

        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getMenuByRestaurant(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }
}