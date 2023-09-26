package com.inventory_management.services;

import com.inventory_management.db.entity.UserEntity;
import com.inventory_management.db.repositories.RolesRepo;
import com.inventory_management.db.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RolesRepo rolesRepo;

    public UserEntity findByUserName(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = findByUserName(username);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole().toString())).collect(Collectors.toList()));

    }
}
