package com.edae.users.userControl.web.rest;

import com.edae.users.userControl.dto.UserDTO;
import com.edae.users.userControl.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listRoles(){
        return ResponseEntity.ok().body(userService.listDetailUsers());
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> listDetailedRoles(){
        return ResponseEntity.ok().body(userService.listDetailUsers());
    }}
