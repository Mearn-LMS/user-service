package kz.mearn.user_service.user.dto.response;

import kz.mearn.user_service.user.entity.User;

public record AuthenticationResponse(
        User user,
        String token
) {}
