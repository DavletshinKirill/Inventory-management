package com.inventory_management.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends BaseEntityDTO {

    @Schema(description = "Название Товара", example = "Кресло")
    @NotBlank(message = "Название Товара обязательно")
    private String title;

    @Schema(description = "Название Товара", example = "Кресло")
    @NotBlank(message = "Название Товара обязательно")
    private String description;

    @Schema(description = "Цена товара", example = "599.99")
    @NotNull(message = "Цена товара не должна быть равно нулю")
    private double price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String photo;

    @Schema(description = "Количество Товара", example = "10")
    @NotNull(message = "Количество Товара не должно быть равно нулю")
    private int stockQuantity;
}
