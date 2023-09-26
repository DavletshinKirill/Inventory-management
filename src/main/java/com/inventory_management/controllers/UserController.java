package com.inventory_management.controllers;

import com.inventory_management.dto.OrderDTO;
import com.inventory_management.dto.UserDTO;
import com.inventory_management.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/users/")
@Api("Controller for get, update, create, delete users. Add orders")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("get/{id}")
    public UserDTO getUser(@PathVariable("id")Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.creteUser(userDTO);
    }

    @DeleteMapping(value="delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable("id")Long userId)
    {
        userService.deleteUser(userId);
    }

    @PostMapping(value = "addOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO addOrder(@PathVariable("id")Long userId, @RequestBody OrderDTO orderDTO) {
        return userService.addOrder(userId, orderDTO);
    }

    // Add Pagination
    @GetMapping("getAllUsers/{id}")
    public ArrayList<UserDTO> getUsers(@RequestParam(defaultValue = "0") int pageNo,
                                       @RequestParam(defaultValue = "5") int pageSize)
    {
        return userService.getAllUsers();
    }
}
