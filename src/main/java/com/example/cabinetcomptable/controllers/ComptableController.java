package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.Comptable;
import com.example.cabinetcomptable.repositories.ComptableRepository;
import com.example.cabinetcomptable.services.ComptableService;
import com.example.cabinetcomptable.services.impl.ComptableServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ComptableController {

    @Autowired
    private ComptableService comptableService;
    @Autowired
    private ComptableRepository comptableRepository;


    @PostMapping("/login")
    public ResponseEntity<?> loginComptable(@RequestBody Comptable comptable){

        if(comptableService.check(comptable)){
            return ResponseEntity.ok(comptable);

        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }





}
