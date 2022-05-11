package com.example.cabinetcomptable;
import com.example.cabinetcomptable.repositories.BonAchatRepository;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class CabinetComptableApplication implements CommandLineRunner {

    @Autowired
    private GenerateFormatService g ;

    @Autowired
    private BonAchatRepository bonAchatRepository;

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args){
        SpringApplication.run(CabinetComptableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //System.out.println(clientRepository.findTopByOrderByIdDesc().getId());
        //System.out.println(bonAchatRepository.findTopByOrderById_baDesc());
        System.out.println(g.formatCodeClient(1));
        System.out.println(g.formatCodeFournisseur(23));
        System.out.println(g.formatNumeroBonAchat(12,new Date()));
    }
}
