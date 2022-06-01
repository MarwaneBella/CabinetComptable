package com.example.cabinetcomptable.entities.dto;

import com.example.cabinetcomptable.entities.Client;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BonHonoraireDto implements Serializable {
    private  long idBh;
    private  String bonHNum;
    private  Date dateBh;
    private  boolean valide;
    private  boolean status;
    private  double montantTotal;
    private  double montantPayer;
    private  Client client;

    
}
