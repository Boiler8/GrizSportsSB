package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8100")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Register a new user (passwords will be hashed)
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        // Hash the password before saving to DB
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    // Login endpoint (validate username & password)
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Compare hashed passwords
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return "Login successful!";
            }
        }
        return "Invalid username or password";
    }
}
