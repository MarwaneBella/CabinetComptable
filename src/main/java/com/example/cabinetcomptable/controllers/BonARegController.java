package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.BonAReg;
import com.example.cabinetcomptable.services.BonARegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BonARegController {

    @Autowired
    private BonARegService bonARegService ;

    // get BonAReg :

    @GetMapping("bonARegs/{id_ba_reg}")
    public ResponseEntity<BonAReg> getBonAReg(@PathVariable long id_ba_reg){
        return bonARegService.getBonAReg(id_ba_reg);
    }

    // get BonARegs :

    @GetMapping("bonARegs")
    public List<BonAReg> getAllBonARegs(){
        return bonARegService.getAllBonARegs();
    }

    // add BonReg :
    @PostMapping("bonARegs")
    public ResponseEntity<BonAReg> addBonAReg(@RequestBody BonAReg bonAReg){
        return  bonARegService.addBonAReg(bonAReg);
    }

    // update BonReg :
    @PutMapping("/bonARegs/{id_ba_reg}")
        public void updateBonReg(@PathVariable long id_ba_reg , @RequestBody BonAReg bonAReg){
            bonARegService.updateBonAReg(id_ba_reg,bonAReg);
    }

    // Delete BonAReg :
    @DeleteMapping("/bonARegs/{id_ba_reg}")
        public  void deleteBonReg(@PathVariable long id_ba_reg){
        bonARegService.deleteBonAReg(id_ba_reg);
    }
}
