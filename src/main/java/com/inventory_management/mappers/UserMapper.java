package com.inventory_management.mappers;

import com.inventory_management.db.entity.Product;
import com.inventory_management.db.entity.User;
import com.inventory_management.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}
