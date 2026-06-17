package com.deliverychoco.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateRestaurantRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String cuisine;
}