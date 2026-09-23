package com.example.hireflow.dto.user;

import com.example.hireflow.entity.type.AccountStatus;
import com.example.hireflow.entity.type.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(

        @Email(message = "Invalid email format")
        String email,

        @Size(max = 100)
        String firstName,

        @Size(max = 100)
        String lastName,

        @Size(max = 30)
        String phone,

        RoleType role,

        AccountStatus accountStatus

) {
}