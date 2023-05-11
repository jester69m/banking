package com.pet.banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cust_id", referencedColumnName = "id")
    private List<Account> accounts = new ArrayList<>();

//    public void addAccount(Account account) {
//        accounts.add(account);
//        account.setCustomer(this);
//    }
//
//    public void removeAccount(Account account) {
//        accounts.remove(account);
//        account.setCustomer(null);
//    }

}