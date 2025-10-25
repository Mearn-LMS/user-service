package kz.mearn.user_service.service;

import kz.mearn.user_service.service.exception.UserNotFoundException;
import kz.mearn.user_service.user.entity.User;
import kz.mearn.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User register(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> findByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    public List<User> findByUsernames(List<String> usernames) {
        return repository.findByUsernameIn(usernames);
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public boolean exists(String username) {
        return repository.existsByUsername(username);
    }
}
