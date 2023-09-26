package com.inventory_management.services;
import com.inventory_management.db.entity.Order;
import com.inventory_management.db.entity.UserEntity;
import com.inventory_management.db.repositories.UserRepo;
import com.inventory_management.dto.OrderDTO;
import com.inventory_management.dto.UserDTO;
import com.inventory_management.mappers.OrderMapper;
import com.inventory_management.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDTO getUser(Long userId) {
        return checkUserDTO(userRepo.findById(userId));
    }

    public ArrayList<UserDTO> getAllUsers() {
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) userRepo.findAll();
        return UserMapper.INSTANCE.listToDTO(users);
    }

    private UserDTO checkUserDTO(Optional<UserEntity> userOptional) {
        if (userOptional.isPresent()) {
            return UserMapper.INSTANCE.toDto(userOptional.get());
        }
        else {
            throw new NullPointerException("User is null");
        }
    }

    private UserEntity checkUserEntity(Optional<UserEntity> userOptional) {
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        else {
            throw new NullPointerException("User is null");
        }
    }

    public UserDTO creteUser(UserDTO userDTO) {
        UserEntity user = UserMapper.INSTANCE.toEntity(userDTO);
        return UserMapper.INSTANCE.toDto(userRepo.save(user));
    }

    public UserDTO updateUsername(Long userId, String username) {
        UserEntity user = checkUserEntity(userRepo.findById(userId));
        user.setUsername(username);
        return UserMapper.INSTANCE.toDto(userRepo.save(user));
    }

    public UserDTO updateEmail(Long userId, String email) {
        UserEntity user = checkUserEntity(userRepo.findById(userId));
        user.setEmail(email);
        return UserMapper.INSTANCE.toDto(userRepo.save(user));
    }

    public UserDTO updatePassword(Long userId, String password) {
        UserEntity user = checkUserEntity(userRepo.findById(userId));
        user.setPassword(password);
        return UserMapper.INSTANCE.toDto(userRepo.save(user));
    }

    public UserDTO addOrder(Long userId, OrderDTO orderDTO) {
        UserEntity user = checkUserEntity(userRepo.findById(userId));
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);
        user.addOrder(order);
        return UserMapper.INSTANCE.toDto(userRepo.save(user));
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
