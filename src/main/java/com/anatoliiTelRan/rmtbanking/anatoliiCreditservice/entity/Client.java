package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "manager_id", length = 16)
    private short managerId;


    @Column(name = "status", length = 1)
    private Integer status;


    @Column(name = "tax_code", nullable = false, length = 20)
    private String taxCode;
    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = true)
    public Manager manager;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Basic
    @Column(name = "address", nullable = false, length = 80)
    private String address;

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;


    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


}
