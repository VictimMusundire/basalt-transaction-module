package com.basalt.basalttransactionmodule.repositories;


import com.basalt.basalttransactionmodule.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Victim Musundire
 */
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByNumber(String account);
}
