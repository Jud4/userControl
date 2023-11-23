package com.edae.users.userControl.services.implement;

import com.edae.users.userControl.domain.entities.User;
import com.edae.users.userControl.domain.entities.UserDetail;
import com.edae.users.userControl.dto.CreateUserDTO;
import com.edae.users.userControl.dto.UserDTO;
import com.edae.users.userControl.repositories.UserDetailRepository;
import com.edae.users.userControl.repositories.UserRepository;
import com.edae.users.userControl.services.UserService;
import com.edae.users.userControl.services.mapper.UserDetailMapper;
import com.edae.users.userControl.services.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserDetailRepository userDetailRepository;
    private final UserDetailMapper userDetailMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserDetailRepository userDetailRepository, UserDetailMapper userDetailMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listDetailUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDetailedDTO).toList();
    }

    @Override
    public CreateUserDTO save(CreateUserDTO dto) {
        return userMapper.toCreatedDTO(userRepository.save(userMapper.toEntity(dto)));
    }

    @Override
    public UserDTO saveDetailed(UserDTO dto) {
        User user = userRepository.save(userMapper.toEntity(dto));

        if(dto.getDetails()!= null){
            UserDetail userDetail = userDetailMapper.toEntity(dto.getDetails());
            userDetail.setUser(user);
            userDetailRepository.save(userDetail);
        }

        return userMapper.toDto(user);
    }

    @Override
    public CreateUserDTO editUser(UserDTO dto) {
        User user = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toCreatedDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
