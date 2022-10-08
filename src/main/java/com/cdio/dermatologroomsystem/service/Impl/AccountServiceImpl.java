package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Account;
import com.cdio.dermatologroomsystem.entity.Role;
import com.cdio.dermatologroomsystem.repository.AccountRepository;
import com.cdio.dermatologroomsystem.repository.RoleRepository;
import com.cdio.dermatologroomsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String username) {
        Account account = accountRepository.findByUsername(username);
        if (account != null)
            accountRepository.delete(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void addRoleToAccount(String username, int roleId) {
        Account account = accountRepository.findByUsername(username);
        Role role = roleRepository.findById(roleId).get();
        account.getRoles().add(role);
        accountRepository.save(account);
    }

    @Override
    public void initRoleAndAccount() {
        Role adminRole = new Role();
        adminRole.setRole_name("ROLE_Admin");
        roleRepository.save(adminRole);

        Role doctorRole = new Role();
        doctorRole.setRole_name("ROLE_Doctor");
        roleRepository.save(doctorRole);

        Role userRole = new Role();
        userRole.setRole_name("ROLE_Patient");
        roleRepository.save(userRole);

        Account adminUser = new Account();
        adminUser.setUsername("admin");
        adminUser.setPassword(getEncodedPassword("123123"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        accountRepository.save(adminUser);
    }

    @Override
    public Boolean existAccountByUsername(String username) {
        return null;
    }

    @Override
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
