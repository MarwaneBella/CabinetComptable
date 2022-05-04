package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.Client;

import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import com.example.cabinetcomptable.services.FileStorageService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Response;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.File;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    ServletContext context;

    // get client :
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id) {
        return clientService.getClient(id);
    }

    // get clients :
    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    // add Client :
    @PostMapping( "/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return  clientService.addClient(client);
    }

    // update client :
    @PutMapping("/clients/{id}")
    public void updateClient(@PathVariable long id, @RequestBody Client client) throws Exception{
        clientService.updateClient(id,client);
    }

    // delete client :
    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }

    @GetMapping("/imageclient")
    public ResponseEntity<String> getImage(){
        return ResponseEntity.ok(clientService.getFile());
    }

    @PutMapping("/imageclient")
    public void addFile(@RequestParam("file") MultipartFile file) {
        clientService.addFile(file);
    }
}
