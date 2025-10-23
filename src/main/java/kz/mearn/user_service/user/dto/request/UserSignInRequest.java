package kz.mearn.user_service.user.dto.request;

public record UserSignInRequest(
        String username,
        String password
) {
}
