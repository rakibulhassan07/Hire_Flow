package com.example.hireflow.service;

import com.example.hireflow.dto.user.UserCreateRequest;
import com.example.hireflow.dto.user.UserResponse;
import com.example.hireflow.dto.user.UserUpdateRequest;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(
            Long id,
            UserUpdateRequest request
    );

    void deleteUser(Long id);
}