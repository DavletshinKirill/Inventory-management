package com.inventory_management.web.dto;

import com.inventory_management.domain.OrderStatus;
import com.inventory_management.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO extends BaseEntityDTO {
    private List<Product> products;

    @Schema(description = "Статус заказа",
            example = "ORDER_NOT_PAID",
            allowableValues = {"ORDER_NOT_PAID", "ORDER_PAID", "ORDER_PROCESSING", "ORDER_DELIVERED", "ORDER_COMPLETED"})
    @NotNull(message = "Статус заказа обязателен")
    private OrderStatus status;
}
