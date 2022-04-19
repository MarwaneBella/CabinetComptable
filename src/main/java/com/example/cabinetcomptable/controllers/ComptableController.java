package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Comptable;
import com.example.cabinetcomptable.services.ComptableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
@RestController
public class ComptableController {

    @Autowired
    private ComptableService comptableService;


    @PostMapping("/login")
    public ResponseEntity<?> loginComptable(@RequestBody Comptable comptable){

        if(comptableService.check(comptable)){
            return ResponseEntity.ok(comptable);

        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }





}
