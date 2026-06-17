package com.deliverychoco.controller;

import com.deliverychoco.dto.CreateMenuItemRequest;
import com.deliverychoco.entity.MenuItem;
import com.deliverychoco.service.MenuItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public MenuItem createMenuItem(
            @RequestBody CreateMenuItemRequest request) {

        return menuItemService.createMenuItem(request);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItem> getMenuByRestaurant(
            @PathVariable Long restaurantId) {

        return menuItemService.getMenuByRestaurant(restaurantId);
    }
}