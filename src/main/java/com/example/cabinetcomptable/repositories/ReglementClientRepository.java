package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.ReglementClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglementClientRepository extends JpaRepository<ReglementClient,Long> {
}
