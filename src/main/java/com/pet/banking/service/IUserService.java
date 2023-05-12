package com.pet.banking.service;

import com.pet.banking.entity.User;

import java.util.Optional;

public interface IUserService {

    Iterable<User> getAllUsers();

    Optional<User> getUserById(Long id);

    void addUser(User user);

    Optional<User> updateUser(Long id, User user);

    Optional<User> deleteUser(Long id);
}
