package com.pet.banking.service;

import com.pet.banking.entity.Transaction;
import com.pet.banking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TransactionService implements ITransactionService<Long>{

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransaction() {
        log.info("Getting all transaction in service");
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        log.info("Getting transaction by id in service");
        Optional<Transaction> found = transactionRepository.findById(id);
        if(found.isEmpty()){
            log.info("Transaction not found");
            return found;
        }
        return found;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        log.info("Adding transaction in service");
        transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> deleteTransaction(Long id) {
        log.info("Deleting transaction in service");
        Optional<Transaction> found = transactionRepository.findById(id);
        if(found.isEmpty()){
            log.info("Transaction not found");
            return found;
        }
        transactionRepository.deleteById(id);
        return found;
    }
}
