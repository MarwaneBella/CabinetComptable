package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.dto.BonAchatDto;
import com.example.cabinetcomptable.services.BonAchatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BonAchatController {

    @Autowired
    private ModelMapper modelMapper;

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

    //
    @GetMapping("bonAchatDto/{id}")
    public ResponseEntity<BonAchatDto> getBonAchatById(@PathVariable(name = "id") Long id) {
        BonAchat bonAchat = bonAchatService.getB(id);

        System.out.println(bonAchat.getBonANum());
        // convert entity to DTO
        BonAchatDto bonAchatDto = modelMapper.map(bonAchat, BonAchatDto.class);
        System.out.println(bonAchatDto.getBonANum());
        return ResponseEntity.ok().body(bonAchatDto);
    }

    @GetMapping("bonAchatDto")
    public List<BonAchatDto> getAllBonAchatsDto() {
      //  List<BonAchat> bonAchat = bonAchatService.getAllBonAchats();

      //  System.out.println(bonAchat.get(1).getBonANum());
        // convert entity to DTOList<BonAchatDto> bonAchatDto = modelMapper.map(bonAchat, BonAchatDto.class);
      //  System.out.println(bonAchatDto.getBonANum());
        return bonAchatService.getAllBonAchats().stream().map(b ->modelMapper.map(b,BonAchatDto.class)).collect(Collectors.toList());
    }
}
