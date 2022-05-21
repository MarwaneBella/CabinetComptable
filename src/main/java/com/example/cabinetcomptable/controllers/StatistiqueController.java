package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/statistiques")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StatistiqueController {

    @Autowired
    StatistiqueService statistiqueService;

    @GetMapping("/getNumbersOfAll")
    public ResponseEntity< Map<String,Long> > getNumbersOfAll(){
        return ResponseEntity.ok(statistiqueService.countNumberOfAll());

    }

}
