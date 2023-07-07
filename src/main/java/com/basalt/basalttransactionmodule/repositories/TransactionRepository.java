package com.basalt.basalttransactionmodule.repositories;

import com.basalt.basalttransactionmodule.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Victim Musundire
 */
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
