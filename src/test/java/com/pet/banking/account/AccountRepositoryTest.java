package com.pet.banking.account;

import com.pet.banking.entity.Account;
import com.pet.banking.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryTest {

    @Mock
    private AccountRepository repos;

    @Test
    void testFindById() {
        Account acc = new Account();
        acc.setId(1L);
        acc.setBalance(1000);

        //return the mock account
        when(repos.findById(1L)).thenReturn(Optional.of(acc));

        Optional<Account> result = repos.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(acc, result.get());
    }

    @Test
    void testSave() {

        Account acc = new Account();
        acc.setId(1L);
        acc.setBalance(1000);

        when(repos.save(acc)).thenReturn(acc);

        Account saved = repos.save(acc);

        assertNotNull(saved.getId());
    }

}
