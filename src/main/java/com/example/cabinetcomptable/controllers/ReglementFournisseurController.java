package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.ReglementFournisseur;
import com.example.cabinetcomptable.services.ReglementFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReglementFournisseurController {
    
    @Autowired
    private ReglementFournisseurService reglementFournisseurService;


    // get ReglementFournisseur :

    @GetMapping("reglementFournisseurs/{id_reg_f}")
    public ResponseEntity<ReglementFournisseur> getReglementFournisseur(@PathVariable long id_reg_f){
        return reglementFournisseurService.getReglementFournisseur(id_reg_f);
    }

    // get BonARegs :

    @GetMapping("reglementFournisseurs")
    public List<ReglementFournisseur> getAllReglementFournisseurs(){
        return reglementFournisseurService.getAllReglementFournisseurs();
    }

    // add ReglementFournisseur :
    @PostMapping("reglementFournisseurs")
    public ResponseEntity<ReglementFournisseur> addReglementFournisseur(@RequestBody ReglementFournisseur reglementFournisseur){
        return  reglementFournisseurService.addReglementFournisseur(reglementFournisseur);
    }

    // update ReglementFournisseur :
    @PutMapping("/reglementFournisseurs/{id_reg_f}")
    public void updateReglementFournisseur(@PathVariable long id_reg_f , @RequestBody ReglementFournisseur reglementFournisseur){
        reglementFournisseurService.updateReglementFournisseur(id_reg_f,reglementFournisseur);
    }

    // Delete ReglementFournisseur  :
    @DeleteMapping("/reglementFournisseurs/{id_reg_f}")
    public  void deleteReglementFournisseur(@PathVariable long id_reg_f){
        reglementFournisseurService.deleteReglementFournisseur(id_reg_f);
    }


}
