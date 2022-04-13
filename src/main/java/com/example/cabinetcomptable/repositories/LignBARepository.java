package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.LignBA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignBARepository extends JpaRepository<LignBA,Long> {
}
