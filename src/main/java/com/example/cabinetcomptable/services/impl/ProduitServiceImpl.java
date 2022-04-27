package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Produit;
import com.example.cabinetcomptable.repositories.ProduitRepository;
import com.example.cabinetcomptable.services.ProduitService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;
    @Override
    public ResponseEntity<Produit> addProduit(@RequestParam("file") MultipartFile file, @RequestParam("produit") String produitData) throws JsonParseException, JsonMappingException, Exception {
        System.out.println("Ok .............");
        String path = "src/main/resources/Images";
        System.out.println(path);
        Produit produit = new ObjectMapper().readValue(produitData, Produit.class);
        boolean isExit = new File(path).exists();
        if (!isExit) {
            new File (path).mkdir();
            System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (path+File.separator+newFileName);
        System.out.println(newFileName);
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        produit.setImage(newFileName);
        produitRepository.save(produit);

        return ResponseEntity.ok(produit);
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
