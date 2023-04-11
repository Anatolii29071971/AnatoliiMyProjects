package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "manager_id", nullable = false)
    private short managerId;


    @Column(name = "status")
    private short status;


    @Column(name = "tax_code", nullable = false, unique = true, length = 20)
    private String taxCode;

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


    @Column(name = "created_at")
    private Timestamp createdAt;


    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Client(short managerId, short status, String taxCode,
                  String firstName, String lastName,
                  String email, String address, String phone) {
        this.managerId = managerId;
        if (status <= 125 && status > -125) {
            this.status = status;
        } else {
            this.status = -125;
        }
        this.taxCode = taxCode.toUpperCase();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        java.util.Date date = new Date();
        this.createdAt = new Timestamp(date.getTime());

    }

}
