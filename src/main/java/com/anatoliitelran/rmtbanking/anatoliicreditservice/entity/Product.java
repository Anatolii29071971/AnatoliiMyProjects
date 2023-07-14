package com.anatoliitelran.rmtbanking.anatoliicreditservice.entity;

import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.CurrencyType;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @Column(name = "currency_code")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyCode;
    @Column(name = "interest_rate")
    private float interestRate;
    @Column(name = "limit")
    private int limit;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Agreement> agreement;
    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private Set<Manager> managers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.interestRate, interestRate) == 0 && Objects.equals(name, product.name) && status == product.status && currencyCode == product.currencyCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, currencyCode, interestRate);
    }
}
