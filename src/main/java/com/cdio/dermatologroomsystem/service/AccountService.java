package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Account;
import com.cdio.dermatologroomsystem.entity.AccountDoctor;
import com.cdio.dermatologroomsystem.entity.AccountPatient;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account addAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(String username);
    Account findByUsername(String username);
    Account findById(int id);
    void addRoleToAccount(String username, int roleId);
    void initRoleAndAccount();
    Boolean existAccountByUsername(String username);
    String getEncodedPassword(String password);
    void createPatientAccount(AccountPatient accountPatient);
    void createDoctorAccount(AccountDoctor accountDoctor);
    List<String> findAllUsername();
}
