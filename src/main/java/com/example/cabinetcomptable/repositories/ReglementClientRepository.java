package com.example.cabinetcomptable.repositories;

import entities.ReglementClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglementClientRepository extends JpaRepository<ReglementClient,Long> {
}
