package com.example.hireflow.mapper;

import com.example.hireflow.dto.user.UserCreateRequest;
import com.example.hireflow.dto.user.UserResponse;
import com.example.hireflow.dto.user.UserUpdateRequest;
import com.example.hireflow.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateRequest request) {

        return User.builder()
                .email(request.email())
                .password(request.password())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phone(request.phone())
                .role(request.role())
                .build();
    }

    public void updateEntity(
            User user,
            UserUpdateRequest request
    ) {

        if (request.email() != null) {
            user.setEmail(request.email());
        }

        if (request.firstName() != null) {
            user.setFirstName(request.firstName());
        }

        if (request.lastName() != null) {
            user.setLastName(request.lastName());
        }

        if (request.phone() != null) {
            user.setPhone(request.phone());
        }

        if (request.role() != null) {
            user.setRole(request.role());
        }

        if (request.accountStatus() != null) {
            user.setAccountStatus(request.accountStatus());
        }
    }

    public UserResponse toResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getRole(),
                user.getAccountStatus(),
                user.isEmailVerified(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}