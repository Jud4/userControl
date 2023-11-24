package com.edae.users.userControl.web.rest;

import com.edae.users.userControl.dto.UserRolDTO;
import com.edae.users.userControl.exceptions.BadArgsException;
import com.edae.users.userControl.services.UserRolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserRolDTO>> addRolesToUser(@Valid @RequestBody final List<UserRolDTO> roles,
                                           @PathVariable final Long userId){
        if(roles.isEmpty()){
            throw new BadArgsException("Invalid Request: The body must contain one item at least");
        }
        return ResponseEntity.ok().body(userRolService.save(roles, userId));
    }
    @PatchMapping("/{id}/noActive")
    public ResponseEntity<UserRolDTO> editActiveStatus(@PathVariable final Integer id,
                                                       @PathVariable final Long userId){
        return ResponseEntity.ok().body(userRolService.deactivate(userId,id));
    }
}
