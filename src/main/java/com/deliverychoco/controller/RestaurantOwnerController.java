package com.deliverychoco.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantOwnerController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Restaurant Owner Dashboard";
    }
}