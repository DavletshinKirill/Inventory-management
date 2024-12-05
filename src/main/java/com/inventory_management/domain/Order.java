package com.inventory_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "user_id")
    private UUID userId;
}
