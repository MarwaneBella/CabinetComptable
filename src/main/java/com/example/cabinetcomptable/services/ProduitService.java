package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Produit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProduitService {

    ResponseEntity<Produit> addProduit(Produit produit);
    ResponseEntity<Produit> getProduit(String reference);
    List<Produit> getAllProduits();
    List<Produit> selectProduitsOrderByCategorie();

    ResponseEntity<Produit> updateProduit(Produit produitDtails , String reference);
    void deleteProduit(String reference);
    String getFile();
    void addFile(MultipartFile file);


}
