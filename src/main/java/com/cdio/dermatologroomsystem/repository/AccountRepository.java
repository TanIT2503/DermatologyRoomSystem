package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsername(String username);
    Account findAccountById(int account_id);
}
