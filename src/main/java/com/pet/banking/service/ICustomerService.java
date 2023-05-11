package com.pet.banking.service;

import com.pet.banking.entity.Customer;

import java.util.Optional;

public interface ICustomerService {

    Iterable<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    void addCustomer(Customer customer);

    Optional<Customer> updateCustomer(Long id, Customer customer);

    Optional<Customer> deleteCustomer(Long id);
}
