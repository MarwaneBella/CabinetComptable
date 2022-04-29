package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Produit;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.ProduitRepository;
import com.example.cabinetcomptable.services.FileStorageService;
import com.example.cabinetcomptable.services.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    FileStorageService fileStorageService ;

    @Autowired
    ServletContext context;

    private String pathFolder = "produitImages";

    private static Produit currentProduit  =null;

    public  ProduitServiceImpl(ProduitRepository produitRepository){
        this.produitRepository=produitRepository ;
    }
    @Override
    public ResponseEntity<Produit> addProduit(Produit produit) {
        System.out.println(produit.getCategorie());
        currentProduit=produitRepository.save(produit);
        return ResponseEntity.ok(produit);
    }

    @Override
    public ResponseEntity<Produit> getProduit(String reference) {
        currentProduit = produitRepository.findById(reference).orElseThrow(() -> new ResourceNotFoundException("Produit not found for this reference :: " + reference));
        return ResponseEntity.ok(currentProduit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public ResponseEntity<Produit> updateProduit(Produit produit, String reference) {
        currentProduit = produitRepository.findById(reference).orElseThrow(() -> new ResourceNotFoundException("Produit not found for this reference :: " + reference));
        produit.setReference(reference);
        produit.setImage(currentProduit.getImage());

        currentProduit = produitRepository.save(produit);
        return ResponseEntity.ok(produit);
    }

    @Override
    public void deleteProduit(String reference) {
        currentProduit = produitRepository.findById(reference).orElseThrow(() -> new ResourceNotFoundException("Produit not found for this reference :: " + reference));
        fileStorageService.deleteFile(pathFolder+"/"+currentProduit.getImage());
        produitRepository.deleteById(reference);
    }

    @Override
    public String getFile() {
        return fileStorageService.loadFile(pathFolder+"/"+currentProduit.getImage());
    }

    @Override
    public void addFile(MultipartFile file) {
       if(currentProduit.getImage() !=null){
           fileStorageService.deleteFile(pathFolder+"/"+currentProduit.getImage());
       }
       currentProduit.setImage(fileStorageService.uploadFile(file,pathFolder));
       currentProduit =produitRepository.save(currentProduit);
    }
}
