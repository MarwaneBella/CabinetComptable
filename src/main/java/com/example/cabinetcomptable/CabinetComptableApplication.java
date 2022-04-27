package com.example.cabinetcomptable;

import com.example.cabinetcomptable.entities.Client;
import com.example.cabinetcomptable.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CabinetComptableApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabinetComptableApplication.class, args);

    }

}
