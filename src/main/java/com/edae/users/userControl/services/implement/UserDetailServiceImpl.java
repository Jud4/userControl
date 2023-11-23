package com.edae.users.userControl.services.implement;

import com.edae.users.userControl.dto.UserDetailDTO;
import com.edae.users.userControl.repositories.UserDetailRepository;
import com.edae.users.userControl.services.UserDetailService;
import com.edae.users.userControl.services.mapper.UserDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;
    private final UserDetailMapper userDetailMapper;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailMapper userDetailMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    public UserDetailDTO getUserDetailById(Long id) {
        return userDetailMapper.toDto(userDetailRepository.findByUserId(id));
    }
}
