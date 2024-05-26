package com.aftercare.aftercareapi.Security;

import com.aftercare.aftercareapi.Security.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    //TODO Modify depending on the user

    @PostMapping("/token")
    public Map<String, String> generateToken(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        // In a real application, you would validate the user's credentials here
        String token = jwtUtil.generateToken(username, Arrays.asList("USER"));
        String refreshToken = jwtUtil.generateRefreshToken(username);
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
}
