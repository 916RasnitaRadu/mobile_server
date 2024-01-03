package com.example.Server.controller;

import com.example.Server.converter.TransactionConverter;
import com.example.Server.dto.TransactionDTO;
import com.example.Server.model.Transaction;
import com.example.Server.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class TransactionController {
    private final TransactionRepository transactionRepository;

    private final TransactionConverter transactionConverter;

    public TransactionController(TransactionRepository transactionRepository, TransactionConverter transactionConverter) {
        this.transactionRepository = transactionRepository;
        this.transactionConverter = transactionConverter;
    }

    @GetMapping("/transactions")
    public Set<TransactionDTO> getTransactions() {
        System.out.println("GET ALL TRANSACTIONS");
        return transactionConverter.convertModelsToDtos(transactionRepository.findAll());
    }

    @PostMapping("/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        System.out.println("POST TRANSACTION");

        return transactionRepository.save(transaction);
    }

    @DeleteMapping("/transactions/{id}")
    public Transaction deleteTransaction(@PathVariable long id) {
        System.out.println("DELETE TRANSACTION");
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);

        if (transactionOptional.isEmpty()) return null;

        transactionRepository.deleteById(id);
        return transactionOptional.get();
    }

    @PutMapping("/transactions/{id}")
    public Transaction updateTransaction(@PathVariable long id, @RequestBody Transaction transaction) {
        System.out.println("PUT TRANSACTION");
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);

        if (transactionOptional.isEmpty()) { return null; }

        return transactionRepository.save(transaction);
    }
}
