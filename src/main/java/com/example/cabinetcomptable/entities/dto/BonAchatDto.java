package com.example.cabinetcomptable.entities.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BonAchatDto implements Serializable {
    private  long idBa;
    private  String bonANum;
    private  String facBonNum;
    private  Date dateBa;
    private  boolean valide;
    private  float totalGeneral;
}
