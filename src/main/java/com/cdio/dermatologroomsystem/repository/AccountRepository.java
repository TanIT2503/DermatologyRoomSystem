package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
    @Query(value = "select username from account", nativeQuery = true)
    List<String> findAllUsername();
}
