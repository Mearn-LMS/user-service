package com.ulms.user_service.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ulms.user_service.user.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credentials_id", referencedColumnName = "id")
    private UserCredentials credentials;

    public User(String username, String email, String password, Set<UserRole> roles, UserCredentials credentials) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.credentials = credentials;
    }
}
