package com.ulms.user_service.controller.authentication;

import com.ulms.user_service.security.JwtUtil;
import com.ulms.user_service.service.UserService;
import com.ulms.user_service.user.dto.request.UserSignInRequest;
import com.ulms.user_service.user.dto.request.UserSignUpRequest;
import com.ulms.user_service.user.dto.response.AuthenticationResponse;
import com.ulms.user_service.user.entity.User;
import com.ulms.user_service.user.entity.UserCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody UserSignInRequest request) {
        log.debug("Got new login request: {}", request);

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        final User user = userService.findByUsername(userDetails.getUsername());

        final AuthenticationResponse response = new AuthenticationResponse(
                user,
                jwtUtils.generateToken(userDetails)
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody UserSignUpRequest request) {
        log.debug("Got new signup request: {}", request);

        final UserCredentials credentials = new UserCredentials(
                request.firstName(),
                request.lastName()
        );

        final User user = new User(
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password()),
                request.roles(),
                credentials
        );

        return ResponseEntity.ok(userService.register(user));
    }
}
