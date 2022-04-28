package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Client;

import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import com.example.cabinetcomptable.services.FileStorageService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    FileStorageService fileStorageService ;

    @Autowired
    ServletContext context;

    private String pathFolder = "clientImages";

    private static Client currentClient  =null;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }



    @Override
    public ResponseEntity<Client> addClient(Client client){

        client.setData_de_transaction(new Date());
        currentClient = clientRepository.save(client);
        return ResponseEntity.ok(client);

    }

    @Override
    public ResponseEntity<Client> getClient(long id) {
        currentClient = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
        return ResponseEntity.ok(currentClient);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ResponseEntity<Client> updateClient(long id, Client client ) {
        currentClient = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));

        client.setId(id);
        client.setImage(currentClient.getImage());
        currentClient = clientRepository.save(client);

        return ResponseEntity.ok(client);
    }


    @Override
    public void deleteClient(long id) {
        currentClient = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
        fileStorageService.deleteFile(pathFolder+"/"+currentClient.getImage());
        clientRepository.deleteById(id);
    }

    @Override
    public void addFile(MultipartFile file){

        if(currentClient.getImage() != null){
            fileStorageService.deleteFile(pathFolder+"/"+currentClient.getImage());
        }
        currentClient.setImage(fileStorageService.uploadFile(file, pathFolder));
        currentClient = clientRepository.save(currentClient);
    }

    @Override
    public String getFile(){
        return fileStorageService.loadFile(pathFolder+"/"+currentClient.getImage());
    }


}
