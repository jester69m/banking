package com.pet.banking.controller;

import com.pet.banking.entity.Account;
import com.pet.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable String id,@RequestBody Account account) {
        Account existingAccount = accountService.getAccountById(id);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }
        existingAccount.setType(account.getType());
        existingAccount.setBalance(account.getBalance());
        existingAccount.setOwnerId(account.getOwnerId());

        accountService.updateAccount(account);

        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }

}
