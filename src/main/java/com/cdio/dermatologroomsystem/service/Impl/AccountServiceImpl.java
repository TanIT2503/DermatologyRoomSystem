package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Account;
import com.cdio.dermatologroomsystem.entity.Role;
import com.cdio.dermatologroomsystem.repository.AccountRepository;
import com.cdio.dermatologroomsystem.repository.RoleRepository;
import com.cdio.dermatologroomsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

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
        return accountRepository.findAccountById(id);
    }

    @Override
    public void addRoleToAccount(String username, int roleId) {
        Account account = accountRepository.findByUsername(username);
        Role role = roleRepository.findById(roleId).get();
        account.getRoles().add(role);
        accountRepository.save(account);
    }
}
