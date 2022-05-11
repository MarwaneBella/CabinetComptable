package com.example.cabinetcomptable;
import com.example.cabinetcomptable.repositories.BonAchatRepository;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;


@SpringBootApplication
@EnableJpaAuditing
public class CabinetComptableApplication implements CommandLineRunner {



    public static void main(String[] args){
        SpringApplication.run(CabinetComptableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
