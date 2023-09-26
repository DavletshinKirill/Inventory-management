package com.inventory_management.config;

import com.inventory_management.db.entity.BaseRoles;
import com.inventory_management.db.entity.Product;
import com.inventory_management.db.entity.RolesEntity;
import com.inventory_management.db.entity.UserEntity;
import com.inventory_management.db.repositories.ProductRepo;
import com.inventory_management.db.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Initializer {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;

    public void initial() {
        ArrayList<RolesEntity> user1Roles = new ArrayList<>();
        user1Roles.add(new RolesEntity("user1", BaseRoles.USER));
        UserEntity user1 = new UserEntity("user1", "kirichka27@gmail.com", "1234", user1Roles);
        ArrayList<RolesEntity> admin1Roles = new ArrayList<>();
        admin1Roles.add(new RolesEntity("admin1", BaseRoles.ADMIN));
        UserEntity user2 = new UserEntity("admin1", "kirill.davletshin.2022@gmail.com", "12345", admin1Roles);
        userRepo.save(user1);
        userRepo.save(user2);
    }

    private void addProducts() {
        Product product = new Product("Диван", "Удобный диван для гостиной.", 699.99, "https://cdn.domdivanov.com/files/imgs/ig1111922/divan-pryamoi-blister-bd-3-590x430");
    }
}
