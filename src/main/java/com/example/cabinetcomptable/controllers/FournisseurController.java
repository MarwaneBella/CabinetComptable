package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/fournisseur")
@RestController
public class FournisseurController {

    @Autowired
    FournisseurService fournisseurService;

    // get fournisseur :
    @GetMapping("/Fournisseur/{id}")
    public ResponseEntity<Fournisseur> getFournisseurs(@PathVariable long id){
        return fournisseurService.getFournisseur(id);
    }

    // get All fournisseur :
    @GetMapping("listFournisseur")
    public List<Fournisseur> getAllFournisseur(){
        return fournisseurService.getAllFournisseurs();
    }

    // add fournisseur :
    @PostMapping("/addFournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurService.addFournisseur(fournisseur);
    }

    // update fournisseur :
    @PutMapping("/updateFournisseur/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur ,@PathVariable long id){
        return fournisseurService.updateCFournisseur(fournisseur,id);
    }

    // delete fournisseur :
    @DeleteMapping("/deleteFournisseur/{id}")
    public void  deleteFournisseur(@PathVariable long id){
        fournisseurService.deleteFournisseur(id);
    }


}
