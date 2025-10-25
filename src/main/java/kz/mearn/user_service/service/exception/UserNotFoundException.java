package kz.mearn.user_service.service.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User with username " + username + " wasn't found");
    }

    public UserNotFoundException(Long id) {
        super("User with ID " + id + " wasn't found");
    }
}
