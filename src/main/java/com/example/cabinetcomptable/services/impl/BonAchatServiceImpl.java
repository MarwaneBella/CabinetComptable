package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.LignBA;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.BonAchatRepository;
import com.example.cabinetcomptable.repositories.LignBARepository;
import com.example.cabinetcomptable.services.BonAchatService;
import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class BonAchatServiceImpl implements BonAchatService {

    @Autowired
    BonAchatRepository bonAchatRepository;

    @Autowired
    LignBARepository lignBARepository;

    @Autowired
    GenerateFormatService generateFormatService;


    private static BonAchat currentBonAchat  =null;
    private static Set<LignBA> currentListLignBA  = null;

    public  BonAchatServiceImpl(BonAchatRepository bonAchatRepository){
        this.bonAchatRepository=bonAchatRepository ;
    }

    @Override
    public String getNextBonANum(Date date){
        return generateFormatService.formatNumeroBonAchat(date);
    }

    @Override
    @Transactional
    public ResponseEntity<BonAchat> addBonAchat(BonAchat bonAchat) {


        bonAchat.setBonANum(generateFormatService.formatNumeroBonAchat(bonAchat.getDateBa()));
        currentListLignBA = bonAchat.getListLignBA();
        bonAchat.setListLignBA(null);
        currentBonAchat=bonAchatRepository.save(bonAchat);

        for (LignBA currentvalue : currentListLignBA) {
            currentvalue.setBonAchat(currentBonAchat);
        }

        currentBonAchat.setListLignBA(currentListLignBA);

        return ResponseEntity.ok(bonAchat);
    }

    @Override
    public ResponseEntity<BonAchat> getBonAchat(long id_ba) {
        currentBonAchat = bonAchatRepository.findById(id_ba).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this reference :: " + id_ba));
        return ResponseEntity.ok(currentBonAchat);
    }

    @Override
    public List<BonAchat> getAllBonAchats() {
        return bonAchatRepository.findAll();
    }

    @Override
    public ResponseEntity<BonAchat> updateBonAchat(BonAchat bonAchat, long id_ba) {

        currentBonAchat = bonAchatRepository.findById(id_ba).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this reference :: " + id_ba));



        currentListLignBA = currentBonAchat.getListLignBA();

        currentBonAchat.setListLignBA(null);
        lignBARepository.deleteAll(currentListLignBA);

        bonAchat.setIdBa(id_ba);
        currentListLignBA = bonAchat.getListLignBA();
        bonAchat.setListLignBA(null);

        currentBonAchat = bonAchatRepository.save(bonAchat);


        for (LignBA currentvalue : currentListLignBA) {
            currentvalue.setBonAchat(currentBonAchat);
        }

        currentBonAchat.setListLignBA(currentListLignBA);

        bonAchatRepository.save(currentBonAchat);

        return ResponseEntity.ok(bonAchat);
    }

    @Override
    public void deleteBonAchat(long id_ba) {
        currentBonAchat = bonAchatRepository.findById(id_ba).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this reference :: " + id_ba));

        bonAchatRepository.deleteById(id_ba);
    }

}
