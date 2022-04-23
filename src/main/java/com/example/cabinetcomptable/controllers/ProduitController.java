package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Produit;
import com.example.cabinetcomptable.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api")
@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // add produit :
    @PostMapping("/produits")
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }

    // get Produit :
    @GetMapping("/produits/{reference}")
    public ResponseEntity<Produit> getProduit(@PathVariable String reference){
        return produitService.getProduit(reference);
    }

    // get All Produit :
    @GetMapping("/produits")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    // update Produit :
    @PutMapping("/produits/{reference}")
    public  ResponseEntity<Produit> updateProduit(@RequestBody Produit produit , @PathVariable String reference){
        return  produitService.updateProduit(produit , reference);
    }

    // delete Produit :
    @DeleteMapping("/produits/{reference}")
    public  void deleteProduit(@PathVariable String reference){
        produitService.deleteProduit(reference);
    }




}
