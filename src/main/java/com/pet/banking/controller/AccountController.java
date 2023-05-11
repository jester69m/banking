package com.pet.banking.controller;

import com.pet.banking.entity.Account;
import com.pet.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
@Log4j2
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        log.info("Getting all accounts in controller");
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        log.info("Getting account by id in controller");
        Optional<Account> found = accountService.getAccountById(id);
        if(found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
    }

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        log.info("Adding account in controller");
        accountService.addAccount(account);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id,@RequestBody Account account) {
        log.info("Updating account in controller");

        Optional<Account> updated = accountService.updateAccount(id, account);
        if(updated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Long id) {
        log.info("Deleting account in controller");
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }

}
