package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Fournisseur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FournisseurService {

    Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur);
    ResponseEntity<Fournisseur> getFournisseur(long id);
    List<Fournisseur> getAllFournisseurs();
    ResponseEntity<Fournisseur> updateCFournisseur(Fournisseur fournisseur ,long id);
    void deleteFournisseur(long id);
}
