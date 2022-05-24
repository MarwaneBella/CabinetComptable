package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.ReglementFournisseur;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface ReglementFournisseurService {

    String getNextCodeReglementFournisseur(Date date);

    ResponseEntity<ReglementFournisseur> addReglementFournisseur(ReglementFournisseur reglementFournisseur) ;
    ResponseEntity<ReglementFournisseur> getReglementFournisseur(long id_reg_f);
    List<ReglementFournisseur> getAllReglementFournisseurs();
    ResponseEntity<ReglementFournisseur> updateReglementFournisseur(long id_reg_f, ReglementFournisseur client);
    void deleteReglementFournisseur(long id_reg_f);

}
