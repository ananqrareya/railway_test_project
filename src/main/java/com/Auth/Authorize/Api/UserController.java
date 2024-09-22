package com.Auth.Authorize.Api;

import com.Auth.Authorize.Dto.UserDTO;
import com.Auth.Authorize.entity.User;
import com.Auth.Authorize.servicse.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:5174")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO) {
        try {

            userService.registerUser(userDTO);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during registration: " + e.getMessage());
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>>getAllUsers(){
        List<User>users=userService.getAllUser();
        return ResponseEntity.ok(users);
    }
}
