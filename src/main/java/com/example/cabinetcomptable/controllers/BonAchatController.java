package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.services.BonAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BonAchatController {

    @Autowired
    private BonAchatService bonAchatService;


    // add bonAchat :
    @PostMapping("/bon-achat")
    public ResponseEntity<BonAchat> addBonAchat(@RequestBody BonAchat bonAchat) {
        return bonAchatService.addBonAchat(bonAchat);
    }

    // get BonAchat :
    @GetMapping("/bon-achat/{id_ba}")
    public ResponseEntity<BonAchat> getBonAchat(@PathVariable Long id_ba){
        return bonAchatService.getBonAchat(id_ba);
    }

    // get All BonAchat :
    @GetMapping("/bon-achat")
    public List<BonAchat> getAllBonAchats(){
        return bonAchatService.getAllBonAchats();
    }

    // update BonAchat :
    @PutMapping("/bon-achat/{id_ba}")
    public  ResponseEntity<BonAchat> updateBonAchat(@RequestBody BonAchat bonAchat , @PathVariable Long id_ba){
        return  bonAchatService.updateBonAchat(bonAchat ,id_ba);
    }

    // delete BonAchat :
    @DeleteMapping("/bon-achat/{id_ba}")
    public  void deleteBonAchat(@PathVariable Long id_ba){
        bonAchatService.deleteBonAchat(id_ba);
    }

}
