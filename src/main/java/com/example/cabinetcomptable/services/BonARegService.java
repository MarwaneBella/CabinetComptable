package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.BonAReg;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BonARegService {

    ResponseEntity<BonAReg> addBonAReg(BonAReg bonAReg) ;
    ResponseEntity<BonAReg> getBonAReg(long id_ba_reg);
    List<BonAReg> getAllBonARegs();
    ResponseEntity<BonAReg> updateBonAReg(long id_ba_reg, BonAReg bonAReg);
    void deleteBonAReg(long id_ba_reg);

}
