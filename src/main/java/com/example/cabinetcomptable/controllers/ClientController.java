package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.Client;

import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    //test :
    @Autowired
    private ClientRepository clientRepository;
    // end test ;



    // get client :
    @GetMapping("/oneClient/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id){
        return  clientService.getClient(id);
    }

    // get clients :
    @GetMapping("/listClient")
    public List<Client> getAllClients(){
        System.out.println("hello");
        return clientService.getAllClients();
    }
    // add Client :
    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public Client addClient(@RequestBody Client client){
        // return clientService.addClient(client);
        System.out.println("hello");
        return clientRepository.save(client);
    }

    // update client :
    @PutMapping("/updateClient/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client clientDtails , @PathVariable long id){
        return  clientService.updateClient(clientDtails,id);
    }
    // delete client :
    @DeleteMapping("deleteClient/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }





}
