package com.pet.banking.service;

import com.pet.banking.entity.Transaction;

import java.util.Optional;

public interface ITransactionService<T> {

    Iterable<Transaction> getAllTransaction();

    Optional<Transaction> getTransactionById(T id);

    void addTransaction(Transaction transaction);

    Optional<Transaction> deleteTransaction(T id);
}
