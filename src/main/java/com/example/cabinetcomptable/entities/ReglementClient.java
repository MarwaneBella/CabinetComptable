package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reglement_client")
public class ReglementClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegC;

    private float avance;
    private float reste;

    @OneToMany (mappedBy = "reglementClient")
    private Set<BonHReg> listBonHReg = new HashSet<BonHReg>();

    public ReglementClient() {
    }

    public ReglementClient(long idRegC, float avance, float reste) {
        this.idRegC = idRegC;
        this.avance = avance;
        this.reste = reste;
    }

    public ReglementClient(float avance, float reste) {
        this.avance = avance;
        this.reste = reste;
    }

    public Set<BonHReg> getListBonHReg() {
        return listBonHReg;
    }

    public void setListBonHReg(Set<BonHReg> listBonHReg) {
        this.listBonHReg = listBonHReg;
    }
}
