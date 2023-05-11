package com.pet.banking.service;

import com.pet.banking.entity.Account;
import com.pet.banking.entity.Customer;
import com.pet.banking.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        log.info("Getting all customers in service");
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        Optional<Customer> found = customerRepository.findById(id);
        if(found.isEmpty()) {
            log.info("Customer not found in service");
            return Optional.empty();
        }
        log.info("Getting customer by id in service");
        return found;
    }

    @Override
    public void addCustomer(Customer customer) {
        log.info("Adding customer in service");
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Long id, Customer customer) {
        Optional<Customer> found = customerRepository.findById(id);
        if(found.isEmpty()) {
            log.info("Customer not found in service");
            return Optional.empty();
        }
        Customer updated = found.get();
        updated.setFirstName(customer.getFirstName());
        updated.setLastName(customer.getLastName());
        updated.setEmail(customer.getEmail());
        updated.setPhone(customer.getPhone());

        if(customer.getAccounts() != null) {
            updated.setAccounts(customer.getAccounts());
        }
        log.info("Updating customer in service");
        return Optional.of(customerRepository.save(updated));
    }

    @Override
    public Optional<Customer> deleteCustomer(Long id) {
        Optional<Customer> found = customerRepository.findById(id);
        if(found.isEmpty()){
            log.info("Customer not found in service");
            return Optional.empty();
        }
        log.info("Deleting customer in service");
        customerRepository.deleteById(id);
        return found;
    }

    public List<Account> getAllAccountsByCustomerId(@PathVariable Long id) {
        Optional<Customer> found = customerRepository.findById(id);
        if(found.isEmpty()) {
            log.info("Customer not found in service");
            return new ArrayList<>();
        }
        log.info("Getting all accounts by customer id in service");
        return found.get().getAccounts();
    }
}
