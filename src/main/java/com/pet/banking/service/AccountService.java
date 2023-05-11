package com.pet.banking.service;

import com.pet.banking.entity.Account;
import com.pet.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        log.info("Getting all accounts in service");
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        log.info("Getting account by id in service");
        return accountRepository.findById(id);
    }

    public void addAccount(Account account) {
        log.info("Adding account in service");
        accountRepository.save(account);
    }

    public Optional<Account> updateAccount(Long id, Account account) {
        Optional<Account> found = accountRepository.findById(id);
        if (found.isEmpty()) {
            log.info("Account not found in service");
            return Optional.empty();
        }
        found.get().setType(account.getType());
        found.get().setBalance(account.getBalance());

        log.info("Updating account in service");
        return Optional.of(accountRepository.save(found.get()));
    }

    public void deleteAccount(Long id) {
        if(!accountRepository.existsById(id)){
            log.info("Account not found in service");
            return;
        }
        log.info("Deleting account in service");
        accountRepository.deleteById(id);
    }
}