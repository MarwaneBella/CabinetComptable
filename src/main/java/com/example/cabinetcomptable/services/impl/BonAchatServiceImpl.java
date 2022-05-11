package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.BonAchatRepository;
import com.example.cabinetcomptable.services.BonAchatService;
import com.example.cabinetcomptable.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@Transactional
public class BonAchatServiceImpl implements BonAchatService {

    @Autowired
    BonAchatRepository bonAchatRepository;


    private static BonAchat currentBonAchat  =null;

    public  BonAchatServiceImpl(BonAchatRepository bonAchatRepository){
        this.bonAchatRepository=bonAchatRepository ;
    }
    @Override
    public ResponseEntity<BonAchat> addBonAchat(BonAchat bonAchat) {

        currentBonAchat=bonAchatRepository.save(bonAchat);
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
        bonAchat.setIdBa(id_ba);

        currentBonAchat = bonAchatRepository.save(bonAchat);
        return ResponseEntity.ok(bonAchat);
    }

    @Override
    public void deleteBonAchat(long id_ba) {
        currentBonAchat = bonAchatRepository.findById(id_ba).orElseThrow(() -> new ResourceNotFoundException("BonAchat not found for this reference :: " + id_ba));

        bonAchatRepository.deleteById(id_ba);
    }

}
