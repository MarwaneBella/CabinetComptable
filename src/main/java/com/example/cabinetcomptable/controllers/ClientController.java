package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.Client;

import com.example.cabinetcomptable.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/client")
@RestController
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;


    //
    @GetMapping("/listClient")
    public List<Client> loginComptable(){

        return clientService.getAllClient();
    }
}
