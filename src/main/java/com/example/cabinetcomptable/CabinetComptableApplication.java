package com.example.cabinetcomptable;

import entities.Client;
import com.example.cabinetcomptable.repositories.ClientRepository;
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

        client.setEmail("Email");
        client.setTele_fix("0566889900");
        client.setNom("BELLA");
        client.setAdresse("HWARA");
        clientRepository.save(client);
    }
}
