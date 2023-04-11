package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

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
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    /*
    @ManyToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "tax_code", nullable = false)
    private Client clientTaxCode;
*/

    @Column(name = " client_tax_code", nullable = false, unique = true, length = 20)
    private String clientTaxCode;


    @Column(name = "account_name", nullable = false, length = 100)
    private String accountName;

    @Column(name = "type", nullable = false)
    private short type;

    @Column(name = "status", nullable = false)
    private short status;

    @Column(name = "balance", nullable = false, precision = 2)
    private BigDecimal balance;


    @Column(name = "currency_code", nullable = false)
    private short currencyCode;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;


    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    public Account(String clientTaxCode, String accountName, short type,
                   short status, BigDecimal balance, short currencyCode) {
        this.clientTaxCode = clientTaxCode;
        this.accountName = accountName;
        if (type <= 125 && type > -125) {
            this.type = type;
        } else {
            this.type = -125;
        }

        if (status <= 125 && status > -125) {
            this.status = status;
        } else {
            this.status = -125;
        }

        this.balance = balance;
        this.currencyCode = currencyCode;

        java.util.Date date = new Date();
        this.createdAt = new Timestamp(date.getTime());
    }

}
