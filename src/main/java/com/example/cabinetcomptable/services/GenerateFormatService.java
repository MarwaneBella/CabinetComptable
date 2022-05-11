package com.example.cabinetcomptable.services;

import java.util.Date;

public interface GenerateFormatService {
    String formatCodeClient(long id);
    String formatCodeFournisseur(long id);
    String formatNumeroBonAchat(long id, Date date);
    String formatNumeroBonHonoraire(long id, Date date);
    String formatNumeroFacture(long id, Date date);
}
