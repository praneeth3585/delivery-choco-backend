package com.deliverychoco.dto;

import lombok.Data;

@Data
public class CreateMenuItemRequest {

    private String name;

    private Double price;

    private Long restaurantId;
}