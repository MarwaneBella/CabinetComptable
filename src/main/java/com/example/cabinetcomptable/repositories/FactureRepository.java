package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
    Facture findTopByOrderByIdFacDesc();
}
