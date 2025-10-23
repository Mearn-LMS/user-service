package com.ulms.user_service.user.dto.response;

import com.ulms.user_service.user.entity.User;

public record AuthenticationResponse(
        User user,
        String token
) {}
