package com.edae.users.userControl.web.rest;

import com.edae.users.userControl.dto.CreateUserDTO;
import com.edae.users.userControl.dto.RolDTO;
import com.edae.users.userControl.dto.UserDTO;
import com.edae.users.userControl.exceptions.BadArgsException;
import com.edae.users.userControl.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed){
        if(detailed){
            return ResponseEntity.ok().body(userService.listDetailUsers());
        }else{
            return ResponseEntity.ok().body(userService.listUsers());
        }
    }
    @PostMapping
    public ResponseEntity<CreateUserDTO> createUser(@Valid @RequestBody final CreateUserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new BadArgsException("I new user cannot already have an id.");
        }

        CreateUserDTO createdUser = userService.save(dto);
        return ResponseEntity.created(new URI("/v1/users/"+createdUser.getId())).body(createdUser);
    }
    @PostMapping("/detailed")
    public ResponseEntity<UserDTO> createDetailedUser(@Valid @RequestBody final UserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new BadArgsException("I new user cannot already have an id.");
        }

        UserDTO createdUser = userService.saveDetailed(dto);
        return ResponseEntity.created(new URI("/v1/users/"+createdUser.getId())).body(createdUser);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editUser(@Valid @RequestBody final UserDTO dto,
                                            @PathVariable final Long id){
        if (dto.getId() == null) {
            throw new BadArgsException("Invalid User id, null value not allowed");
        }

        if (!Objects.equals(id, dto.getId())) {
            throw new BadArgsException("Invalid id");
        }

        return ResponseEntity.ok().body(userService.saveDetailed(dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
