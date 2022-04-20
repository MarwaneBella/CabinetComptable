package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientService {
    Client addClient(@RequestBody Client client);
    ResponseEntity<Client> getClient(long id);
    List<Client> getAllClients();
    ResponseEntity<Client> updateClient(Client clientDtails,long id);
    void deleteClient(long id);

}
