package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;


    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "description",length = 225)
    private String description;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Set<Client> clients = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Set<Product> products = new HashSet<>();

    public Manager(String firstName, String lastName, Integer status,
                   String description, Timestamp createdAt,
                   Set<Client> clients, Set<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
        this.clients = clients;
        this.products = products;
    }
}
