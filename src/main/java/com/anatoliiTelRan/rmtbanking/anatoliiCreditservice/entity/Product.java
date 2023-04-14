package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    /* @ManyToOne
     @Column(name = "manager_id")
     private Manager manager;
 */
    @Column(name = "manager_id")
    private short managerId;
    @Column(name = "name", nullable = false, length = 70)
    private String name;


    @Column(name = "status", length = 1, nullable = false)
    private short status;


    @Column(name = "currency_code", length = 2, nullable = false)
    private Integer currencyCode;


    @Column(name = "interest_rate", nullable = false, precision = 4)
    private BigDecimal interestRate;


    @Column(name = "limit", nullable = false, precision = 2)
    private BigDecimal limit;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;


    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    public Product(short managerId, String name, short status, Integer currencyCode,
                   BigDecimal interestRate, BigDecimal limit) {
        this.managerId = managerId;
        this.name = name;
        this.status = status;
        this.currencyCode = currencyCode;
        this.interestRate=interestRate;
        this.limit = limit;
        java.util.Date date = new Date();
        this.createdAt = new Timestamp(date.getTime());
    }
}
