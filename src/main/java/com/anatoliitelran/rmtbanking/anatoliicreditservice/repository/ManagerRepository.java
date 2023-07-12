package com.anatoliitelran.rmtbanking.anatoliicreditservice.repository;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findManagerById(Long id);
    List<Manager> getAllByClientsNotNull();

}
