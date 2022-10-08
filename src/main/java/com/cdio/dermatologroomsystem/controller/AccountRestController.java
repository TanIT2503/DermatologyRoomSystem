package com.cdio.dermatologroomsystem.controller;


import com.cdio.dermatologroomsystem.entity.Account;
import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.entity.Role;
import com.cdio.dermatologroomsystem.service.AccountService;
import com.cdio.dermatologroomsystem.service.PatientService;
import com.cdio.dermatologroomsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/account")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PatientService patientService;

    @PostConstruct
    public void initRoleAndAccount(){
        accountService.initRoleAndAccount();
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll(){
        List<Account> accounts = accountService.findAll();
        if (accounts.isEmpty()){
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Account> findAccountByUsername(@PathVariable("username") String username){
        try{
            Account account = accountService.findByUsername(username);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Account> deleteAccount(@PathVariable("username") String username){
        try {
            Account account = accountService.findByUsername(username);
            accountService.deleteAccount(username);
            return new ResponseEntity<Account>(account,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<Account> updateAccount(@PathVariable("username") String username, @RequestBody Account account){
        Account accountFind = accountService.findByUsername(username);
        try{
            account.setAccount_id(accountFind.getAccount_id());
            return new ResponseEntity<Account>(accountService.updateAccount(account), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{username}/roles/{roleId}")
    public ResponseEntity<?> addRoleToAccount(@PathVariable("username")String username, @PathVariable("roleId")int roleId){
        Account account = accountService.findByUsername(username);
        Role role = roleService.findById(roleId);
        if (account == null || role == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.addRoleToAccount(username,roleId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/createPatient")
    public ResponseEntity<?> createAccountForNewPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.add(patient),HttpStatus.CREATED);
    }
}
