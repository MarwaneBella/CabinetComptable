package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Produit;
import com.example.cabinetcomptable.repositories.ProduitRepository;
import com.example.cabinetcomptable.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public ResponseEntity<Produit> getProduit(String reference) {
        Produit produit = produitRepository.findById(reference).orElseThrow();
        return ResponseEntity.ok(produit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public ResponseEntity<Produit> updateProduit(Produit produitDtails , String reference) {
       Produit produit = produitRepository.findById(reference).orElseThrow();
       /*
       *
       * Update Produit
       *
       * */
       Produit updateProduit =produitRepository.save(produit);
        return ResponseEntity.ok(updateProduit);
    }

    @Override
    public void deleteProduit(String reference) {
        produitRepository.deleteById(reference);
    }
}
