package com.inventory_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends BaseEntityDTO {

    private String title;

    private String description;

    private double price;

    private int availableQuantity;
}
