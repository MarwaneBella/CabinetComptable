package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Produit;
import com.example.cabinetcomptable.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api")
@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    ServletContext context;
    // add produit :
    @PostMapping("/produits")
    public ResponseEntity<Produit> addProduit(@RequestParam("file") MultipartFile file, @RequestParam("produit") String produitData) throws  Exception{
        return produitService.addProduit(file,produitData);
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
