package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonHonoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonHonoraireRepository extends JpaRepository<BonHonoraire, Long> {

    BonHonoraire findTopByOrderByIdBhDesc();
}
