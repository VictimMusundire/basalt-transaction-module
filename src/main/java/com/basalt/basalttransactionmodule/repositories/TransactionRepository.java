package com.basalt.basalttransactionmodule.repositories;

import com.basalt.basalttransactionmodule.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * @author Victim Musundire
 */
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = ("SELECT SUM(amount)\n" +
            "FROM public.transaction\n" +
            "WHERE account_number = :accountNumber"), nativeQuery = true)
    Double checkBalance(String accountNumber);

}
