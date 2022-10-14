package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Account;
import com.cdio.dermatologroomsystem.entity.AccountDoctor;
import com.cdio.dermatologroomsystem.entity.AccountPatient;
import com.cdio.dermatologroomsystem.entity.Role;
import com.cdio.dermatologroomsystem.repository.AccountRepository;
import com.cdio.dermatologroomsystem.repository.DoctorRepository;
import com.cdio.dermatologroomsystem.repository.PatientRepository;
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
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DoctorRepository doctorRepository;

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
        Role doctorRole = new Role();
        Role userRole = new Role();
        if (roleRepository.findRoleByRoleName("ROLE_Admin") == null){
            adminRole.setRole_name("ROLE_Admin");
            roleRepository.save(adminRole);
        }
        if (roleRepository.findRoleByRoleName("ROLE_Doctor") == null){
            doctorRole.setRole_name("ROLE_Doctor");
            roleRepository.save(doctorRole);
        }
        if (roleRepository.findRoleByRoleName("ROLE_Patient") == null){
            userRole.setRole_name("ROLE_Patient");
            roleRepository.save(userRole);
        }
        if (findByUsername("admin")==null){
            Account adminUser = new Account();
            adminUser.setUsername("admin");
            adminUser.setPassword(getEncodedPassword("123123"));
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            adminUser.setRoles(adminRoles);
            accountRepository.save(adminUser);
        }
    }

    @Override
    public Boolean existAccountByUsername(String username) {
        return null;
    }

    @Override
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    @Override
    public void createPatientAccount(AccountPatient accountPatient) {
        if (accountRepository.findByUsername(accountPatient.getAccount().getUsername()) == null){
            Set<Role> roles = new HashSet<>();
            patientRepository.save(accountPatient.getPatient());
            Role role = roleRepository.findById(3).get();
            roles.add(role);
            Account account = accountPatient.getAccount();
            account.setPassword(getEncodedPassword(accountPatient.getAccount().getPassword()));
            account.setRoles(roles);
            accountPatient.getPatient().setAccount(account);
            patientRepository.save(accountPatient.getPatient());
        }
    }

    @Override
    public void createDoctorAccount(AccountDoctor accountDoctor) {
        if (accountRepository.findByUsername(accountDoctor.getAccount().getUsername()) == null) {
            Set<Role> roles = new HashSet<>();
            doctorRepository.save(accountDoctor.getDoctor());
            Role role = roleRepository.findById(2).get();
            roles.add(role);
            Account account = accountDoctor.getAccount();
            account.setPassword(getEncodedPassword(accountDoctor.getAccount().getPassword()));
            account.setRoles(roles);
            accountDoctor.getDoctor().setAccount(account);
            doctorRepository.save(accountDoctor.getDoctor());
        }
    }

    @Override
    public List<String> findAllUsername() {
        return accountRepository.findAllUsername();
    }
}
