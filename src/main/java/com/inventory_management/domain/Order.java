package com.inventory_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "user_id")
    private UUID userId;
}
