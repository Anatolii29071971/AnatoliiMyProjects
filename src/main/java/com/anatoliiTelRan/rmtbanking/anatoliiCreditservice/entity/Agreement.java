package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "agreement")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account accountId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;


    @Column(name = "interest_rate", nullable = false, precision = 4)
    private BigDecimal interestRate;


    @Column(name = "status", nullable = false)
    private Integer status;


    @Column(name = "sum", nullable = false, precision = 2)
    private BigDecimal sum;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;


    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


}
