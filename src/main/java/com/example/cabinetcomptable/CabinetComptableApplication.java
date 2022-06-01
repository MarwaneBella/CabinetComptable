package com.example.cabinetcomptable;

import com.example.cabinetcomptable.repositories.LignBARepository;
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

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



    public static void main(String[] args){
        SpringApplication.run(CabinetComptableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String path ="C:\\Users\\Sys\\Desktop\\GI\\Book1.xlsx";
        System.out.println("application start");
        //userServiceimpl.ReadDataFromExcel(path);
        System.out.println("application end");

        System.out.println(lignBARepository.selectDesignationTop5ByOrderByQuantitieOfLignBH());
        System.out.println(lignBARepository.selectSumQuantiteTop5ByOrderByQuantitieOfLignBH());


    }
}
