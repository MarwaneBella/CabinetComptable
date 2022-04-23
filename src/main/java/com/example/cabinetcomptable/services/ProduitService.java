package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Produit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProduitService {

    Produit addProduit(Produit produit);
    ResponseEntity<Produit> getProduit(String reference);
    List<Produit> getAllProduits();
    ResponseEntity<Produit> updateProduit(Produit produitDtails , String reference);
    void deleteProduit(String reference);


}
