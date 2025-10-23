package com.ulms.user_service.user.dto.request;

import com.ulms.user_service.user.UserRole;

import java.util.Set;

public record UserSignUpRequest(
        String username,
        String email,
        String password,

        String firstName,
        String lastName,
        Set<UserRole> roles
) {
}
