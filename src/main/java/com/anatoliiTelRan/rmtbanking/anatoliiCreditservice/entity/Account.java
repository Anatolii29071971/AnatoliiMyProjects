package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private short id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_code", nullable = false)
    private Client clientTaxCode;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "type", length = 1, nullable = false)
    private Integer type;

    @Column(name = "status", length = 1, nullable = false)
    private Integer status;

    @Column(name = "balance", nullable = false, precision = 2)
    private BigDecimal balance;


    @Column(name = "currency_code", length = 2, nullable = false)
    private Integer currencyCode;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;


    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    public Account(Client clientTaxCode, String name, Integer type,
                   Integer status, BigDecimal balance, Integer currencyCode) {
        this.clientTaxCode = clientTaxCode;
        this.name = name;
        this.type = type;
        this.status = status;
        this.balance = balance;
        this.currencyCode = currencyCode;
    }

}
