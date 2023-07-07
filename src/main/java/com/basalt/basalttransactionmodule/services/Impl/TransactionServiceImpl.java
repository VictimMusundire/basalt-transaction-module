package com.basalt.basalttransactionmodule.services.Impl;

import com.basalt.basalttransactionmodule.dtos.TransactionDto;
import com.basalt.basalttransactionmodule.enums.DebitCreditIndicator;
import com.basalt.basalttransactionmodule.exceptions.AccountNotFoundException;
import com.basalt.basalttransactionmodule.mappers.AutoTransactionMapper;
import com.basalt.basalttransactionmodule.models.Account;
import com.basalt.basalttransactionmodule.models.Transaction;
import com.basalt.basalttransactionmodule.repositories.AccountRepository;
import com.basalt.basalttransactionmodule.repositories.TransactionRepository;
import com.basalt.basalttransactionmodule.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Victim Musundire
 */

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final RestTemplate restTemplate;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(RestTemplate restTemplate, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.restTemplate = restTemplate;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();

        return transactions.stream().map((transaction) -> AutoTransactionMapper.MAPPER.mapToTransactionDto(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto debit(TransactionDto transactionDto) {

        Account optionalAccount = accountRepository.findByNumber(transactionDto.getAccountNumber())
                .orElseThrow(
                        () -> new AccountNotFoundException("Account not found to debit")
                );

        Transaction transaction = AutoTransactionMapper.MAPPER.mapToTransaction(transactionDto);
        transaction.setCurrency(optionalAccount.getCurrency());
        transaction.setDebitCreditIndicator(DebitCreditIndicator.DEBIT);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return AutoTransactionMapper.MAPPER.mapToTransactionDto(savedTransaction);
    }

    @Override
    public TransactionDto credit(TransactionDto transactionDto) {

        Account optionalAccount = accountRepository.findByNumber(transactionDto.getAccountNumber())
                .orElseThrow(
                   () -> new AccountNotFoundException("Account not found to credit")
                );

        Transaction transaction = AutoTransactionMapper.MAPPER.mapToTransaction(transactionDto);
        transaction.setCurrency(optionalAccount.getCurrency());
        transaction.setDebitCreditIndicator(DebitCreditIndicator.CREDIT);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return AutoTransactionMapper.MAPPER.mapToTransactionDto(savedTransaction);
    }

    @Override
    public Double checkBalance(String accountNumber) {
       accountRepository.findByNumber(accountNumber)
                .orElseThrow(
                        () -> new AccountNotFoundException("Account not found to check balance")
                );
        return transactionRepository.checkBalance(accountNumber);
    }
}
