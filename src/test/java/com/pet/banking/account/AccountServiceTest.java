package com.pet.banking.account;

import com.pet.banking.entity.Account;
import com.pet.banking.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    private AccountService service;

    @Test
    public void testAddAccount() {
        Account acc = new Account();
        acc.setId(1L);
        acc.setBalance(1000);

        service.addAccount(acc);
        when(service.getAccountById(1L)).thenReturn(Optional.of(acc));

        Optional<Account> res = service.getAccountById(1L);
        assertTrue(res.isPresent());
        assertEquals(acc, res.get());
    }
}
