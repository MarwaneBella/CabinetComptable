package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.Client;

import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    // get client :
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id){
        return  clientService.getClient(id);
    }

    // get clients :
    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    // add Client :
    @PostMapping( "/clients")
    public Client addClient(@RequestBody Client client){
         return clientService.addClient(client);
    }

    // update client :
    @PutMapping("/clients/{id}")
    public void updateClient(@RequestBody Client clientDtails , @PathVariable long id){
        clientService.updateClient(clientDtails,id);
    }
    // delete client :
    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }





}
