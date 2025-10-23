package kz.mearn.user_service.user;

public enum UserRole {
    STUDENT("STUDENT"),
    TEACHER("TEACHER"),
    ADMIN("ADMIN");

    private final String stringRepresentation;

    UserRole(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String asString() {
        return this.stringRepresentation;
    }
}
