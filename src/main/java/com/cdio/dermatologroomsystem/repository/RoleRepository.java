package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role where role_name=?1", nativeQuery = true)
    Role findRoleByRoleName(String name);
}
