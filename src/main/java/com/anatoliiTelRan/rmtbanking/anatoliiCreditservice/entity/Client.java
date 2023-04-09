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
@Table(name ="client")
public class Client {

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "manager_id",nullable = false)
    private Integer managerId;


    @Column(name = "status")
    private Integer status;


    @Column(name = "tax_code",nullable = false)
    private String taxCode;
   // @ManyToOne
   // @JoinColumn(name = "manager_id", nullable = true)
    //public Manager manager;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;


    @Column(name = "email",nullable = false)
    private String email;


    @Column(name = "address",nullable = false)
    private String address;


    @Column(name = "phone",nullable = false)
    private String phone;


    @Column(name = "created_at")
    private Timestamp createdAt;


    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Client(Integer managerId, Integer status, String taxCode,
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
