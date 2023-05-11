package com.pet.banking.controller;

import com.pet.banking.entity.Transaction;
import com.pet.banking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/transaction")
@Log4j2
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransaction(){
        log.info("Getting all transaction in controller");
        return ResponseEntity.ok(transactionService.getAllTransaction());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id){
        log.info("Getting transaction by id in controller");
        Optional<Transaction> found = transactionService.getTransactionById(id);
        if(found.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        log.info("Adding transaction in controller");
        transactionService.addTransaction(transaction);
        return ResponseEntity.ok(transaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable Long id) {
        log.info("Deleting transaction in controller");
        Optional<Transaction> found = transactionService.deleteTransaction(id);
        if(found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
    }

}
