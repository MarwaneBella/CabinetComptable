package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.repositories.FournisseurRepository;
import com.example.cabinetcomptable.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;
    public  FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }


    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public ResponseEntity<Fournisseur> getFournisseur(long id) {
        Fournisseur fournisseur= fournisseurRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(fournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public ResponseEntity<Fournisseur> updateCFournisseur(Fournisseur fournisseurDtails, long id) {
        Fournisseur fournisseur =fournisseurRepository.findById(id).orElseThrow();
        fournisseur.setNom(fournisseurDtails.getNom());
        fournisseur.setEmail(fournisseurDtails.getEmail());
        Fournisseur updateClient=fournisseurRepository.save(fournisseur);
        return ResponseEntity.ok(updateClient);
    }

    @Override
    public void deleteFournisseur(long id) {
        fournisseurRepository.deleteById(id);
    }
}
