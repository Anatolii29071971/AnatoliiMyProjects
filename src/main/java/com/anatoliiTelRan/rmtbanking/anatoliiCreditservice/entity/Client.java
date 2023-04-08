package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
            //(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "manager_id", length = 16)
    private short managerId;


    @Column(name = "status", length = 1)
    private Integer status;


    @Column(name = "tax_code", nullable = false, length = 20)
    private String taxCode;
   // @ManyToOne
   // @JoinColumn(name = "manager_id", nullable = true)
    //public Manager manager;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;


    @Column(name = "email", nullable = false, length = 60)
    private String email;


    @Column(name = "address", nullable = false, length = 80)
    private String address;


    @Column(name = "phone", nullable = false, length = 20)
    private String phone;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;


    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    public Client(short managerId, Integer status, String taxCode,
                  String firstName, String lastName,
                  String email, String address, String phone) {
        this.managerId = managerId;
        this.status = status;
        this.taxCode = taxCode;

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;

    }


}
