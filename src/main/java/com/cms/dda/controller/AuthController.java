package com.cms.dda.controller;

import com.cms.dda.security.JwtUtil;
import com.cms.dda.security.LoginRequest;
import com.cms.dda.security.LoginResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /* @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "guest".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok("Bearer " + token);
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }
    */
    
    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    	String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        
        // Create the response object
        LoginResponse response = new LoginResponse();
        
        // Authenticate the user (you can replace this with your authentication logic)
        if (username.equals("admin") && password.equals("guest")) {
            // Generate JWT token
            String token = jwtUtil.generateToken(username);
            long requestTime = System.currentTimeMillis();
            long expiryTime = requestTime + 1000 * 60 * 60 * 10; // 10 hours from the request time

            // Set response details for a valid login
            response.setUsername(username);
            response.setStatus(200);
            response.setRequestTime(requestTime);
            response.setExpiryTime(expiryTime);
            response.setToken(token);
            response.setValid(true);
            response.setMessage("Valid");

            return ResponseEntity.ok(response);
        } else {
            // Set response details for an invalid login
            response.setStatus(401);
            response.setValid(false);
            response.setMessage("Invalid username or password");

            return ResponseEntity.status(401).body(response);  // Return 401 status for invalid login
        }
    }
     
}
