package com.edae.users.userControl.web.rest;

import com.edae.users.userControl.dto.UserRolDTO;
import com.edae.users.userControl.services.UserRolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users/{userId}/roles")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }
    @PostMapping
    public List<UserRolDTO> addRolesToUser(@RequestBody final List<UserRolDTO> roles,
                                           @PathVariable final Long userId){
        if(roles.isEmpty()){
            throw new IllegalArgumentException("Invalid Request: The body must contain one item at least");
        }
        return userRolService.save(roles, userId);
    }
}
