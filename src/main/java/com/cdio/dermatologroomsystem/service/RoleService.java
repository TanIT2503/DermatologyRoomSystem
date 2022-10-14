package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role addRole(Role role);
    Role findById(int id);
    Role findRoleByRoleName(String name);
}
