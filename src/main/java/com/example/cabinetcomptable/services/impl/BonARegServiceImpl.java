package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.BonAReg;
import com.example.cabinetcomptable.repositories.BonARegRepository;
import com.example.cabinetcomptable.services.BonARegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonARegServiceImpl implements BonARegService {

    @Autowired
    private BonARegRepository bonARegRepository ;

    private static BonAReg currenetBonAReg = null ;

    public BonARegServiceImpl(BonARegRepository bonARegRepository) {
        this.bonARegRepository = bonARegRepository;
    }

    @Override
    public ResponseEntity<BonAReg> addBonAReg(BonAReg bonAReg) {
       currenetBonAReg = bonARegRepository.save(bonAReg) ;
        return ResponseEntity.ok(bonAReg);
    }

    @Override
    public ResponseEntity<BonAReg> getBonAReg(long id_ba_reg) {
      currenetBonAReg = bonARegRepository.findById(id_ba_reg).orElseThrow();
        return ResponseEntity.ok(currenetBonAReg);
    }

    @Override
    public List<BonAReg> getAllBonARegs() {
        return bonARegRepository.findAll();
    }

    @Override
    public ResponseEntity<BonAReg> updateBonAReg(long id_ba_reg, BonAReg bonAReg) {
        currenetBonAReg = bonARegRepository.findById(id_ba_reg).orElseThrow();
        bonAReg.setId_ba_reg(id_ba_reg);

        currenetBonAReg =bonARegRepository.save(bonAReg) ;

        return ResponseEntity.ok(bonAReg);
    }

    @Override
    public void deleteBonAReg(long id_ba_reg) {
        currenetBonAReg = bonARegRepository.findById(id_ba_reg).orElseThrow();
        bonARegRepository.deleteById(id_ba_reg);
    }
}
