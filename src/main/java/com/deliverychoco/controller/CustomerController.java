package com.deliverychoco.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Customer Dashboard";
    }
}