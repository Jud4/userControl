package com.edae.users.userControl.web.rest;

import com.edae.users.userControl.dto.RolDTO;
import com.edae.users.userControl.exceptions.BadArgsException;
import com.edae.users.userControl.services.RolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    @GetMapping
    public ResponseEntity<List<RolDTO>> listRoles(){
        return ResponseEntity.ok().body(rolService.listRoles());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id){
        return ResponseEntity.ok()
                .body(rolService.getRolById(id).orElseThrow(() -> new BadArgsException("Rol not found, exception for the id: " + id)));
    }
    @PostMapping
    public ResponseEntity<RolDTO> createRol(@Valid @RequestBody final RolDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new BadArgsException("I new rol cannot already have an id.");
        }

        RolDTO createdRol = rolService.save(dto);

        return ResponseEntity.created(new URI("/v1/roles/"+createdRol.getId())).body(createdRol);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editRol(@Valid @RequestBody final RolDTO dto,
                                          @PathVariable final Integer id){
        if (dto.getId() == null) {
            throw new BadArgsException("Invalid Rol id, null value not allowed");
        }

        if (!Objects.equals(id, dto.getId())) {
            throw new BadArgsException("Invalid id");
        }

        return ResponseEntity.ok().body(rolService.save(dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id){
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
