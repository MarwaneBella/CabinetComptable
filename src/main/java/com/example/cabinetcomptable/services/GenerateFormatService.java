package com.example.cabinetcomptable.services;

import java.util.Date;

public interface GenerateFormatService {
    String formatCodeClient(long id);
    String formatCodeFournisseur(long id);
    String formatNumeroBonAchat(Date date);
    String formatNumeroBonHonoraire(Date date);
    String formatNumeroFacture(Date date);
}
