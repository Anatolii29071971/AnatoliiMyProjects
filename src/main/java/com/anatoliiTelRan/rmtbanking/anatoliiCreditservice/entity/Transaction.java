package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "transaction")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, length = 16, nullable = false)
    private short id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debit_account_id", nullable = false)
    private Account debitAccountId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_account_id", nullable = false)
    private Account creditAccount;


    @Column(name = "type", length = 1, nullable = false)
    private Integer type;


    @Column(name = "amount", nullable = false, precision = 2)
    private BigDecimal amount;


    @Column(name = "description", nullable = false, length = 250)
    private String description;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;


}
