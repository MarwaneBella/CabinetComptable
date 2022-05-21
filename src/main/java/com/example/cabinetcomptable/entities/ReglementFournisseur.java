package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reglement_fournisseur")
public class ReglementFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegF;
    private double avance ;
    private double reste;

    @OneToMany(mappedBy = "bonAreg")
    private Set<BonAReg> listbonAReg = new HashSet<BonAReg>();

    public ReglementFournisseur() {
    }

    public ReglementFournisseur(long idRegF, double avance, double reste) {
        this.idRegF = idRegF;
        this.avance = avance;
        this.reste = reste;
    }

    public ReglementFournisseur(double avance, double reste) {
        this.avance = avance;
        this.reste = reste;
    }

    public long getIdRegF() {
        return idRegF;
    }

    public void setIdRegF(long idRegF) {
        this.idRegF = idRegF;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public Set<BonAReg> getListbonAReg() {
        return listbonAReg;
    }

    public void setListbonAReg(Set<BonAReg> listbonAReg) {
        this.listbonAReg = listbonAReg;
    }
}
