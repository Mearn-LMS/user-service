package kz.mearn.user_service.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_credentials")
@NoArgsConstructor
@Getter
@ToString
public class UserCredentials {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public UserCredentials(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
