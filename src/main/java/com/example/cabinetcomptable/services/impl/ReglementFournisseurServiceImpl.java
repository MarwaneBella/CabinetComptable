package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.ReglementFournisseur;
import com.example.cabinetcomptable.repositories.ReglementFournisseurRepository;
import com.example.cabinetcomptable.services.ReglementFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReglementFournisseurServiceImpl implements ReglementFournisseurService {

    @Autowired
    private ReglementFournisseurRepository reglementFournisseurRepository;

    private static  ReglementFournisseur currentreglementFournisseur = null ;

    public ReglementFournisseurServiceImpl(ReglementFournisseurRepository reglementFournisseurRepository) {
        this.reglementFournisseurRepository = reglementFournisseurRepository;
    }

    @Override
    public ResponseEntity<ReglementFournisseur> addReglementFournisseur(ReglementFournisseur reglementFournisseur) {
        currentreglementFournisseur = reglementFournisseurRepository.save(reglementFournisseur);
        return ResponseEntity.ok(reglementFournisseur);
    }

    @Override
    public ResponseEntity<ReglementFournisseur> getReglementFournisseur(long id_reg_f) {
       currentreglementFournisseur = reglementFournisseurRepository.findById(id_reg_f).orElseThrow();
        return ResponseEntity.ok(currentreglementFournisseur);
    }

    @Override
    public List<ReglementFournisseur> getAllReglementFournisseurs() {
        return reglementFournisseurRepository.findAll();
    }

    @Override
    public ResponseEntity<ReglementFournisseur> updateReglementFournisseur(long id_reg_f, ReglementFournisseur reglementFournisseur) {
        currentreglementFournisseur = reglementFournisseurRepository.findById(id_reg_f).orElseThrow();
        reglementFournisseur.setId_reg_f(id_reg_f);
        currentreglementFournisseur =reglementFournisseurRepository.save(reglementFournisseur);

        return ResponseEntity.ok(reglementFournisseur);
    }

    @Override
    public void deleteReglementFournisseur(long id_reg_f) {
         reglementFournisseurRepository.deleteById(id_reg_f);
    }
}
