package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account addAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(String username);
    Account findByUsername(String username);
    Account findById(int id);
    void addRoleToAccount(String username, int roleId);
}
