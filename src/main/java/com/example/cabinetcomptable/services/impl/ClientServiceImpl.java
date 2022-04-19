package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
}
