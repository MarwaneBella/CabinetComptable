package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reglement_fournisseur")
public class ReglementFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reg_f;
    private float avance ;
    private float reste;

    @OneToMany(mappedBy = "bonAreg")
    private Set<BonAReg> listbonAReg = new HashSet<BonAReg>();

    public ReglementFournisseur() {
    }

    public ReglementFournisseur(long id_reg_f, float avance, float reste) {
        this.id_reg_f = id_reg_f;
        this.avance = avance;
        this.reste = reste;
    }

    public ReglementFournisseur(float avance, float reste) {
        this.avance = avance;
        this.reste = reste;
    }


    public long getId_reg_f() {
        return id_reg_f;
    }

    public void setId_reg_f(long id_reg_f) {
        this.id_reg_f = id_reg_f;
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
