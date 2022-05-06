package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reglement_client")
public class ReglementClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reg_c;

    private float avance;
    private float rest;

    @OneToMany (mappedBy = "reglementClient")
    private Set<BonHReg> listBonHReg = new HashSet<BonHReg>();

    public ReglementClient() {
    }

    public ReglementClient(float avance, float rest) {
        this.avance = avance;
        this.rest = rest;
    }

    public ReglementClient(long id_reg_c, float avance, float rest) {
        this.id_reg_c = id_reg_c;
        this.avance = avance;
        this.rest = rest;
    }

    public long getId_reg_c() {
        return id_reg_c;
    }

    public void setId_reg_c(long id_reg_c) {
        this.id_reg_c = id_reg_c;
    }

    public float getAvance() {
        return avance;
    }

    public void setAvance(float avance) {
        this.avance = avance;
    }

    public float getRest() {
        return rest;
    }

    public void setRest(float rest) {
        this.rest = rest;
    }

    public Set<BonHReg> getListBonHReg() {
        return listBonHReg;
    }

    public void setListBonHReg(Set<BonHReg> listBonHReg) {
        this.listBonHReg = listBonHReg;
    }
}
