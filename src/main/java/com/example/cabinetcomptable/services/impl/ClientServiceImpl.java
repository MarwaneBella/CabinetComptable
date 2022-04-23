package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.net.URL;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    ServletContext context;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<Client> addClient(@RequestParam("file") MultipartFile file,
                                            @RequestParam("client") String clientData) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Ok .............");
        String path = "src/main/resources/Images";
        System.out.println(path);
        Client client = new ObjectMapper().readValue(clientData, Client.class);
        boolean isExit = new File(path).exists();
        if (!isExit) {
            new File (path).mkdir();
            System.out.println("mk dir.............");
        }


        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (path+File.separator+newFileName);
        System.out.println(newFileName);
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        client.setImage(newFileName);
        clientRepository.save(client);

        return ResponseEntity.ok(client);
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
