package com.pet.banking.service;

import com.pet.banking.entity.Account;
import com.pet.banking.entity.User;
import com.pet.banking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        log.info("Getting all users in service");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> found = userRepository.findById(id);
        if(found.isEmpty()) {
            log.info("User not found in service");
            return Optional.empty();
        }
        log.info("Getting user by id in service");
        return found;
    }

    @Override
    public void addUser(User user) {
        log.info("Adding user in service");
        userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User user) {
        Optional<User> found = userRepository.findById(id);
        if(found.isEmpty()) {
            log.info("User not found in service");
            return Optional.empty();
        }
        User updated = found.get();
        updated.setFirstName(user.getFirstName());
        updated.setLastName(user.getLastName());
        updated.setEmail(user.getEmail());
        updated.setPhone(user.getPhone());

        if(user.getAccounts() != null) {
            updated.setAccounts(user.getAccounts());
        }
        log.info("Updating user in service");
        return Optional.of(userRepository.save(updated));
    }

    @Override
    public Optional<User> deleteUser(Long id) {
        Optional<User> found = userRepository.findById(id);
        if(found.isEmpty()){
            log.info("User not found in service");
            return Optional.empty();
        }
        log.info("Deleting User in service");
        userRepository.deleteById(id);
        return found;
    }

    public List<Account> getAllAccountsByUserId(@PathVariable Long id) {
        Optional<User> found = userRepository.findById(id);
        if(found.isEmpty()) {
            log.info("User not found in service");
            return new ArrayList<>();
        }
        log.info("Getting all accounts by User id in service");
        return found.get().getAccounts();
    }
}
