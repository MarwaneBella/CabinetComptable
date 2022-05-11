package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.services.GenerateFormatService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenerateFormatServiceImlp implements GenerateFormatService {

    @Override
    public String formatCodeClient(long id) {
        return String.format("C-"+"%04d" , id);
    }

    @Override
    public String formatCodeFournisseur(long id) {
        return String.format("F-"+"%04d" , id);
    }

    @Override
    public String formatNumeroBonAchat(long id, Date date) {
        return date + "  --- " + id;
    }

    @Override
    public String formatNumeroBonHonoraire(long id, Date date) {
        return null;
    }

    @Override
    public String formatNumeroFacture(long id, Date date) {
        return null;
    }
}
