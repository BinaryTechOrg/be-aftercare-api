package com.aftercare.aftercareapi.Security;

import com.aftercare.aftercareapi.Security.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/token")
    public Map<String, String> generateToken(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");
        System.out.println(password);
        // Authenticate user
        authenticate(username, password);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtUtil.generateToken(userDetails.getUsername(), Arrays.asList("USER"));
        String refreshToken = jwtUtil.generateRefreshToken(userDetails.getUsername());

        return Map.of("token", token, "refreshToken", refreshToken);
    }

    @PostMapping("/refresh")
    public Map<String, String> refreshToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        String username = jwtUtil.extractUsername(refreshToken);
        if (jwtUtil.validateToken(refreshToken, username)) {
            String token = jwtUtil.generateToken(username, Arrays.asList("USER"));
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Invalid refresh token");
        }
    }

    private void authenticate(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        System.out.println(passwordEncoder.encode(password));
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

}
