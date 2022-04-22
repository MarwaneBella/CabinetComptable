package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @Override
    public ResponseEntity<Client> getClient(long id) {
        Client client= clientRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ResponseEntity<Client> updateClient(Client clientDtails, long id) {
        Client client =clientRepository.findById(id).orElseThrow();
        client.setNom(clientDtails.getNom());
        client.setEmail(clientDtails.getEmail());
        Client updateClient =clientRepository.save(client);
        return ResponseEntity.ok(updateClient);
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }
}
