package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.ReglementFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReglementFournisseurRepository extends JpaRepository<ReglementFournisseur,Long> {
    @Query("select r from ReglementFournisseur r  where r.idRegF =( select max(rf.idRegF) from ReglementFournisseur rf where year(rf.datePayment) = year(?1) ) ")
    ReglementFournisseur selectLasReglementFournisseur(Date date);
}
