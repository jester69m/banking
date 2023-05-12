package com.pet.banking.controller;

import com.pet.banking.entity.User;
import com.pet.banking.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        log.info("Getting all users in controller");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        log.info("Getting user by id in controller");
        Optional<User> found = userService.getUserById(id);
        if(found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        log.info("Adding user in controller");
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        log.info("Updating user in controller");
        Optional<User> found = userService.updateUser(id, user);
        if(found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        log.info("Deleting user in controller");
        Optional<User> found = userService.deleteUser(id);
        if(found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
    }


}
