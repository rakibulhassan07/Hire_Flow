package com.example.hireflow.dto.user;

import com.example.hireflow.entity.type.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, max = 100,
                message = "Password must be between 6 and 100 characters")
        String password,

        @NotBlank(message = "First name is required")
        @Size(max = 100, message = "First name cannot exceed 100 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(max = 100, message = "Last name cannot exceed 100 characters")
        String lastName,

        @Size(max = 30, message = "Phone cannot exceed 30 characters")
        String phone,

        @NotNull(message = "Role is required")
        RoleType role
) {
}