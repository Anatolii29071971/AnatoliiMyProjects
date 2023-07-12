package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity;

import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.AccountStatus;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.AccountType;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

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
    private Double balance;

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

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Agreement agreement;


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
