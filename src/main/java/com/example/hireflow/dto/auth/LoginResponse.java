package com.example.hireflow.dto.auth;

import com.example.hireflow.entity.type.RoleType;

public record LoginResponse(

        String accessToken,

        String tokenType,

        Long userId,

        String email,

        RoleType role

) {
}