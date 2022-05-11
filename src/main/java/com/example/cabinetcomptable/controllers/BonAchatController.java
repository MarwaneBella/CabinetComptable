package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.services.BonAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BonAchatController {

    @Autowired
    private BonAchatService bonAchatService;

    @PostMapping("/bonAchat/next")
    public ResponseEntity<String> getNextBonANum(@RequestBody Date date){
        return ResponseEntity.ok(bonAchatService.getNextBonANum(date));
    }

    // add bonAchat :
    @PostMapping("/bonAchat")
    public ResponseEntity<BonAchat> addBonAchat(@RequestBody BonAchat bonAchat) {
        return bonAchatService.addBonAchat(bonAchat);
    }

    // get BonAchat :
    @GetMapping("/bonAchat/{id_ba}")
    public ResponseEntity<BonAchat> getBonAchat(@PathVariable Long id_ba){
        return bonAchatService.getBonAchat(id_ba);
    }

    // get All BonAchat :
    @GetMapping("/bonAchat")
    public List<BonAchat> getAllBonAchats(){
        return bonAchatService.getAllBonAchats();
    }

    // update BonAchat :
    @PutMapping("/bonAchat/{id_ba}")
    public  ResponseEntity<BonAchat> updateBonAchat(@RequestBody BonAchat bonAchat , @PathVariable Long id_ba){
        return  bonAchatService.updateBonAchat(bonAchat ,id_ba);
    }

    // delete BonAchat :
    @DeleteMapping("/bonAchat/{id_ba}")
    public  void deleteBonAchat(@PathVariable Long id_ba){
        bonAchatService.deleteBonAchat(id_ba);
    }

}
