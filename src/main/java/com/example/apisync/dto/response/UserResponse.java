package com.example.apisync.dto.response;

import com.example.apisync.constant.Constants;
import com.example.apisync.dto.BaseDto;
import com.example.apisync.model.Role;
import com.example.apisync.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse extends BaseDto {
    private String username;
    private Set<Role> roles;

    public static User toEntity(UserResponse dto) {
        return Constants.map().convertValue(dto, User.class);
    }

    public static UserResponse toDto(User entity) {
        return Constants.map().convertValue(entity, UserResponse.class);
    }
}
