package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.BonAchat;
import com.example.cabinetcomptable.entities.LignBA;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LignBAService {

    ResponseEntity<LignBA> addLignBA(LignBA lignBA);
    ResponseEntity<LignBA> getLignBA(long id_lign_a);
    List<LignBA> getAllLignBAs();
    ResponseEntity<LignBA> updateLignBA(LignBA lignBA , long id_lign_a);
    void deleteLignBA(long id_lign_a);

}
