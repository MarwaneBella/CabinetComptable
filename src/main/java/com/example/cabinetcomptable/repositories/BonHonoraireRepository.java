package com.example.cabinetcomptable.repositories;

import entities.BonHonoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonHonoraireRepository extends JpaRepository<BonHonoraire, Long> {
}
