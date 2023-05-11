package com.pet.banking.repository;

import com.pet.banking.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DataJpaTest
public class AccountRepositoryJUnitTests {

    @Autowired
    private AccountRepository repository;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
        Account acc1 = new Account();
        acc1.setId(1L);
        acc1.setBalance(1000);
        repository.save(acc1);

        Account acc2 = new Account();
        acc2.setId(2L);
        acc2.setBalance(2000);
        repository.save(acc2);
    }

    @Test
    public void findByIdTest() {
        Optional<Account> found = repository.findById(2L);
        assertTrue(found.isPresent());
        assertEquals(found.get().getBalance(), 2000);
    }

}
