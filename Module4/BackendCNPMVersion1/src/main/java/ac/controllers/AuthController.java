package ac.controllers;

import ac.models.User;
import ac.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        try {
            // Save user to the database
            userRepository.save(user);
            String token = generateToken(user); // Implement token generation logic
            return ResponseEntity.status(201).body(new ResponseMessage("User registered successfully", token, user));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseMessage("An error occurred during registration"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            // Find user by email
            User foundUser = userRepository.findByEmail(user.getEmail());
            if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.status(401).body(new ResponseMessage("Invalid credentials"));
            }
            String token = generateToken(foundUser); // Implement token generation logic
            return ResponseEntity.ok(new ResponseMessage("Login successful", token, foundUser));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseMessage("An error occurred during login"));
        }
    }

    private String generateToken(User user) {
        // Implement JWT token generation logic here
        return "generated_token"; // Placeholder
    }

    private static class ResponseMessage {
        private String message;
        private String token;
        private User user;

        public ResponseMessage(String message) {
            this.message = message;
        }

        public ResponseMessage(String message, String token, User user) {
            this.message = message;
            this.token = token;
            this.user = user;
        }

        // Getters and setters
    }
}