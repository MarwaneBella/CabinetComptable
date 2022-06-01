package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Facture;
import com.example.cabinetcomptable.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@CrossOrigin("*")
@RestController
public class FactureController {

    @Autowired
    private FactureService factureService;

    @PostMapping("/factures/next")
    public ResponseEntity<String> getNextFactureNum(@RequestBody Date date){
        return ResponseEntity.ok(factureService.getNextFactureNum(date));
    }
   
    // get facture :
    @GetMapping("/factures/{idFac}")
    public ResponseEntity<Facture> getFacture(@PathVariable long idFac) {
        return factureService.getFacture(idFac);
    }

    // get factures :
    @GetMapping("/factures")
    public List<Facture> getAllFactures(){
        return factureService.getAllFactures();
    }

    // add Facture :
    @PostMapping( "/factures")
    public ResponseEntity<Facture> addFacture(@RequestBody Facture facture) {
        return  factureService.addFacture(facture);
    }

 
    // delete facture :
    @DeleteMapping("factures/{idFac}")
    public void deleteFacture(@PathVariable long idFac){
        factureService.deleteFacture(idFac);
    }



}
