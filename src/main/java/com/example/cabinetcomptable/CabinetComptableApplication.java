package com.example.cabinetcomptable;

import com.example.cabinetcomptable.controllers.ComptableController;
import com.example.cabinetcomptable.entities.Comptable;
import com.example.cabinetcomptable.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CabinetComptableApplication   {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public static void main(String[] args) {
        SpringApplication.run(CabinetComptableApplication.class, args);

    }

}
