package com.example.hireflow.dto.user;

import com.example.hireflow.entity.type.AccountStatus;
import com.example.hireflow.entity.type.RoleType;

import java.time.LocalDateTime;

public record UserResponse(

        Long id,

        String email,

        String firstName,

        String lastName,

        String phone,

        RoleType role,

        AccountStatus accountStatus,

        boolean emailVerified,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {
}