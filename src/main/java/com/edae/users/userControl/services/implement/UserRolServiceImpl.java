package com.edae.users.userControl.services.implement;

import com.edae.users.userControl.domain.entities.User;
import com.edae.users.userControl.domain.entities.UserRol;
import com.edae.users.userControl.dto.UserRolDTO;
import com.edae.users.userControl.repositories.UserRepository;
import com.edae.users.userControl.repositories.UserRolRepository;
import com.edae.users.userControl.services.UserRolService;
import com.edae.users.userControl.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolMapper userRolMapper;
    private final UserRepository userRepository;
    private final UserRolRepository userRolRepository;

    public UserRolServiceImpl(UserRolMapper userRolMapper, UserRepository userRepository, UserRolRepository userRolRepository) {
        this.userRolMapper = userRolMapper;
        this.userRepository = userRepository;
        this.userRolRepository = userRolRepository;
    }

    @Override
    public List<UserRolDTO> save(List<UserRolDTO> dtos, Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(()->new IllegalArgumentException("There is not any User with ID: "+ idUser));

        List<UserRol> userRoles = dtos
                .stream()
                .map(dto -> {
                    var userRol = userRolMapper.toEntity(dto, user);
                    userRol.setCreatedAt(LocalDateTime.now());
                    return userRol;
                })
                .toList();

        return userRolRepository.saveAll(userRoles)
                .stream()
                .map(userRolMapper::toDto).toList();
    }

    @Override
    public UserRolDTO deactivate(Long userId, Integer id) {
        UserRol userRol = userRolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("There is not any UserRol with ID: "+id));
        if(userRol.getUser().getId() != userId){
            throw new IllegalArgumentException("This User doesn't contain the requested role");
        }
        userRol.setActive(false);
        userRol = userRolRepository.save(userRol);
        return userRolMapper.toDto(userRol);
    }
}
