package com.pet.banking.service;

import com.pet.banking.entity.Account;

import java.util.Optional;

public interface IAccountService {
    Iterable<Account> getAllAccounts();

    Optional<Account> getAccountById(Long id);

    void addAccount(Account account);

    Optional<Account> updateAccount(Long id, Account account);

    void deleteAccount(Long id);
}
