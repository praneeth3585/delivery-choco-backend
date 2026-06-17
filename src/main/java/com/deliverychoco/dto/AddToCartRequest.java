package com.deliverychoco.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {

    private Long cartId;

    private Long menuItemId;

    private Integer quantity;
}