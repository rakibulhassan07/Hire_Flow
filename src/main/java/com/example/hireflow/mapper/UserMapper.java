package com.example.hireflow.mapper;

import com.example.hireflow.dto.user.UserCreateRequest;
import com.example.hireflow.dto.user.UserResponse;
import com.example.hireflow.dto.user.UserUpdateRequest;
import com.example.hireflow.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateRequest request);

    UserResponse toResponse(User user);

    void updateEntity(
            UserUpdateRequest request,
            @MappingTarget User user
    );
}