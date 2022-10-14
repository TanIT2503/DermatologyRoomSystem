package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Role;
import com.cdio.dermatologroomsystem.repository.RoleRepository;
import com.cdio.dermatologroomsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role findRoleByRoleName(String name) {
        return roleRepository.findRoleByRoleName(name);
    }
}
