package com.inventory_management.mappers;

import com.inventory_management.db.entity.UserEntity;
import com.inventory_management.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDTO toDto(UserEntity userEntity);

    UserEntity toEntity(UserDTO userDTO);

    ArrayList<UserDTO> listToDTO(ArrayList<UserEntity> listOfPosts);
}
