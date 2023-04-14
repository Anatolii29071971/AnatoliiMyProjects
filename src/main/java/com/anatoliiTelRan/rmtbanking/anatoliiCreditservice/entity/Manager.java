package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;
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
    private short status;

    @Column(name = "description",length = 225)
    private String description;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

/*

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Set<Client> clients = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Set<Product> products = new HashSet<>();

    public Manager(String firstName, String lastName, short status,
                   String description,
                   Set<Client> clients, Set<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (status <= 125 && status > -125) {
            this.status = status;
        } else {
            this.status = -125;
        }
        this.description = description;
        java.util.Date date = new Date();
        this.createdAt = new Timestamp(date.getTime());
        this.clients = clients;
        this.products = products;
    }


 */
    public Manager(String firstName, String lastName, short status,
                   String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (status <= 125 && status > -125) {
            this.status = status;
        } else {
            this.status = -125;
        }
        this.description = description;
        java.util.Date date = new Date();
        this.createdAt = new Timestamp(date.getTime());

    }

    public void setId(Integer id) {
        this.id = id;
    }
}
