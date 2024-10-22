package com.tzxy.minsu.controller;

import com.tzxy.minsu.entity.User;
import com.tzxy.minsu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static java.util.regex.Pattern.matches;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            user.setPassword(user.getPassword());
            User registeredUser = userService.saveUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error during registration: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = userService.findUserByUsername(user.getUsername());
        if (existingUser != null && matches(user.getPassword(), existingUser.getPassword())) {
            // 这里可以添加生成JWT或设置Session的逻辑
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
}
