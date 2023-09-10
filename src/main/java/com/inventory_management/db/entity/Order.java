package com.inventory_management.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id", updatable=true)
    private List<Product> products;

    @Column(name = "status", nullable = false)
    private String status;
}
