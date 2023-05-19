package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.repository;


import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
