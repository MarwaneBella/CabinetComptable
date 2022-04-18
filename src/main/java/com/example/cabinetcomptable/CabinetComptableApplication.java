package com.example.cabinetcomptable;

import com.example.cabinetcomptable.controllers.ComptableController;
import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.entities.Comptable;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CabinetComptableApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository ;

    public static void main(String[] args) {
        SpringApplication.run(CabinetComptableApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        Client client =new Client();
        client.setNom("ESSADIK");
        client.setAdresse("HWARA");
        clientRepository.save(client);
    }
}
