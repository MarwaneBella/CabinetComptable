package com.example.cabinetcomptable.repositories;

import entities.BonAReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonARegRepository extends JpaRepository<BonAReg, Long> {
}
