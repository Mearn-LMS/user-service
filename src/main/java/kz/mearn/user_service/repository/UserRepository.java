package kz.mearn.user_service.repository;

import kz.mearn.user_service.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByUsernameIn(List<String> usernames);
    boolean existsByUsername(String username);
}
