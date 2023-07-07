package com.basalt.basalttransactionmodule.controllers;

import com.basalt.basalttransactionmodule.dtos.TransactionDto;
import com.basalt.basalttransactionmodule.services.TransactionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Victim Musundire
 */

@RestController
@RequestMapping("/transactions")
@Slf4j
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Get Transaction history REST API
    @GetMapping("/all")
    public ResponseEntity<List<TransactionDto>> getAllTransactions(){
        List<TransactionDto> transactionsDtos = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactionsDtos, HttpStatus.OK);
    }


    // Transaction to debit an Account REST API
    @PostMapping("/debit")
    public ResponseEntity<TransactionDto> debit(@Valid @RequestBody TransactionDto transactionDto){
        log.info("This is the debit request ====> " + transactionDto);
        TransactionDto savedTransaction = transactionService.debit(transactionDto);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    // Transaction to credit an Account REST API
    @PostMapping("/credit")
    public ResponseEntity<TransactionDto> credit(@RequestBody TransactionDto transactionDto){
        log.info("This is the credit request ====> " + transactionDto);
        TransactionDto savedTransaction = transactionService.credit(transactionDto);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    // Check Account balance REST API
    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<Double> checkBalance(@PathVariable("accountNumber") String accountNumber){
        log.info("This is the check balance account ====> " + accountNumber);
        Double balance = transactionService.checkBalance(accountNumber);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
