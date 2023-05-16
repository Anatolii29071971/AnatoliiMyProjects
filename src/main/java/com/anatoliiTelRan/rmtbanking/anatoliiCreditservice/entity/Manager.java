package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.enums.ManagerStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ManagerStatus status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "products_managers",
            joinColumns = {@JoinColumn(name = "manager_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> products;
    @OneToMany(mappedBy = "manager", cascade = CascadeType.PERSIST)
    private Set<Client> clients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return firstName.equals(manager.firstName) && lastName.equals(manager.lastName) && clients.equals(manager.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, clients);
    }
}
