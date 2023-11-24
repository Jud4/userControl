package com.edae.users.userControl.services.implement;

import com.edae.users.userControl.dto.RolDTO;
import com.edae.users.userControl.repositories.RolRepository;
import com.edae.users.userControl.services.RolService;
import com.edae.users.userControl.services.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> listRoles() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto).toList();
    }

    @Override
    public Optional<RolDTO> getRolById(Integer rolId) {
        return rolRepository.findById(rolId).map(rolMapper::toDto);
    }

    @Override
    public RolDTO save(RolDTO dto) {
        return this.rolMapper
                .toDto(rolRepository.save(this.rolMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer rolId) {
        rolRepository.deleteById(rolId);
    }
}
