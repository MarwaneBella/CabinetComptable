package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Client;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClientService {
    ResponseEntity<Client> addClient(@RequestParam("file") MultipartFile file,@RequestParam("client") String clientData) throws JsonParseException, JsonMappingException, Exception;
    ResponseEntity<Client> getClient(long id);
    List<Client> getAllClients();
    ResponseEntity<Client> updateClient(Client clientDtails,long id);
    void deleteClient(long id);

}
