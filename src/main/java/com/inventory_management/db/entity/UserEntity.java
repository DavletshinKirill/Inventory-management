package com.inventory_management.db.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity(String username, String email, String password, ArrayList<RolesEntity> roles) {
        this.username = username;
        this.email = email;
        this.password = passwordEncoder.encode(password);
        this.roles = roles;
    }

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id", updatable=true)
    private List<Order> orders;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="user_id", updatable=true)
    private List<RolesEntity> roles;

    public void setPassword(String password){
        this.password = passwordEncoder.encode(password);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
