package com.example.cabinetcomptable;

import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.repositories.LignBARepository;
import com.example.cabinetcomptable.repositories.UserRepository;
import com.example.cabinetcomptable.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CabinetComptableApplication implements CommandLineRunner {

    @Autowired
    LignBARepository lignBARepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientService clientService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



    public static void main(String[] args){
        SpringApplication.run(CabinetComptableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
