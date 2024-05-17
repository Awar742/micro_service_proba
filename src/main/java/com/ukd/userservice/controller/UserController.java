package com.ukd.userservice.controller;

import java.util.List;

import com.ukd.userservice.dto.UserWithNotesDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ukd.userservice.controller.api.UserApi;
import com.ukd.userservice.dto.CreateUserDto;
import com.ukd.userservice.entity.User;
import com.ukd.userservice.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public User createUser(@Valid @RequestBody CreateUserDto user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUserName(@RequestBody @Valid CreateUserDto user, @PathVariable Long id) {
        log.info("Updating user with id: {}", id);
        return userService.updateUser(id, user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "deleted";
    }

    @GetMapping("/{id}/notes")
    public UserWithNotesDto getUserWithNotes(@PathVariable Long id) {
        return userService.getUserNotes(id);
    }
}
