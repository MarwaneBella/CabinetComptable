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
    private float avance ;
    private float reste;

    @OneToMany(mappedBy = "bonAreg")
    private Set<BonAReg> listbonAReg = new HashSet<BonAReg>();

    public ReglementFournisseur() {
    }

    public ReglementFournisseur(long idRegF, float avance, float reste) {
        this.idRegF = idRegF;
        this.avance = avance;
        this.reste = reste;
    }

    public ReglementFournisseur(float avance, float reste) {
        this.avance = avance;
        this.reste = reste;
    }

    public long getIdRegF() {
        return idRegF;
    }

    public void setIdRegF(long idRegF) {
        this.idRegF = idRegF;
    }

    public float getAvance() {
        return avance;
    }

    public void setAvance(float avance) {
        this.avance = avance;
    }

    public float getReste() {
        return reste;
    }

    public void setReste(float reste) {
        this.reste = reste;
    }

    public Set<BonAReg> getListbonAReg() {
        return listbonAReg;
    }

    public void setListbonAReg(Set<BonAReg> listbonAReg) {
        this.listbonAReg = listbonAReg;
    }
}
