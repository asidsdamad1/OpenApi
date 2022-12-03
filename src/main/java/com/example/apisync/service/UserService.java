package com.example.apisync.service;

import com.example.apisync.dto.request.UserRequest;
import com.example.apisync.dto.response.UserResponse;
import com.example.apisync.model.Role;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);

    UserResponse updateUser(UserRequest userRequest, Long id);

    Role saveRole(Role role);

    UserResponse getCurrentUser();

    UserDetails getUserByUsername(String username);

    void addRoleToUser(String username, String roleName);


    Boolean deleteUser(Long id);
}
