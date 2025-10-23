package kz.mearn.user_service.controller.administration;

import kz.mearn.user_service.service.UserService;
import kz.mearn.user_service.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
public class AdministrationUserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/by-id")
    public ResponseEntity<User> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/by-username")
    public ResponseEntity<User> findByUsername(@RequestParam String username) {
        return ResponseEntity.ok(service.findByUsername(username));
    }

    @GetMapping("/by-ids")
    public ResponseEntity<List<User>> findByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findByIds(ids));
    }

    @GetMapping("/by-usernames")
    public ResponseEntity<List<User>> findByUsernames(@RequestParam List<String> usernames) {
        return ResponseEntity.ok(service.findByUsernames(usernames));
    }
}
