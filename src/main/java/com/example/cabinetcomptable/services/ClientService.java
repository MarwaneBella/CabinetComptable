package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ClientService {
    ResponseEntity<Client> addClient(MultipartFile file,String clientData) throws JsonParseException, JsonMappingException, Exception;
    ResponseEntity<Map> getClient(long id) throws ResourceNotFoundException,Exception ;
    List<Client> getAllClients();
    ResponseEntity<Client> updateClient(long id, MultipartFile file,String client) throws JsonParseException, JsonMappingException, Exception;
    void deleteClient(long id);

}
