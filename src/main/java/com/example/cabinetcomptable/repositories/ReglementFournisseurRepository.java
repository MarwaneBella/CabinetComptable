package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.ReglementFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglementFournisseurRepository extends JpaRepository<ReglementFournisseur,Long> {
}
