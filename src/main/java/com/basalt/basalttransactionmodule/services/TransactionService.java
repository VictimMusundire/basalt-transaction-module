package com.basalt.basalttransactionmodule.services;

import com.basalt.basalttransactionmodule.dtos.TransactionDto;

import java.util.List;

/**
 * @author Victim Musundire
 */
public interface TransactionService {

    List<TransactionDto> getAllTransactions();
    TransactionDto debit(TransactionDto transactionDto);
    TransactionDto credit(TransactionDto transactionDto);
    Double checkBalance(String accountNumber);
}
