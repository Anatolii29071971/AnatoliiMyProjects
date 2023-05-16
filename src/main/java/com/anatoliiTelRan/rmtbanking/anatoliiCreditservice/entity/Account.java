package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.enums.AccountStatus;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.enums.AccountType;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @Column(name = "balance")
    private double balance;
    @Column(name = "currency_code")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyCode;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName="id")
    private Client client;
    @OneToMany(mappedBy = "debitAccount", cascade = CascadeType.ALL)
    private Set<Transaction> transactionDebits;
    @OneToMany(mappedBy = "creditAccount", cascade = CascadeType.ALL)
    private Set<Transaction> transactionCredits;
    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private Set<Agreement> agreements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
