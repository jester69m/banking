package com.pet.banking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long UserFromId;
    private Long UserToId;
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeOfTransaction;
}
