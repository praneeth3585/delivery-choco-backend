package com.deliverychoco.service;

import com.deliverychoco.dto.CreateMenuItemRequest;
import com.deliverychoco.entity.MenuItem;

import java.util.List;

public interface MenuItemService {

    MenuItem createMenuItem(CreateMenuItemRequest request);

    List<MenuItem> getMenuByRestaurant(Long restaurantId);
}