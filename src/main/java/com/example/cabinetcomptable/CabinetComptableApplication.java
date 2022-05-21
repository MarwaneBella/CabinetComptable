package com.example.cabinetcomptable;

import com.example.cabinetcomptable.services.impl.UserServiceImpl;
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


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Autowired
    UserServiceImpl userServiceimpl;

    public static void main(String[] args){
        SpringApplication.run(CabinetComptableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String path ="C:\\Users\\Sys\\Desktop\\GI\\Book1.xlsx";
        System.out.println("application start");
        //userServiceimpl.ReadDataFromExcel(path);
        System.out.println("application end");

    }
}
