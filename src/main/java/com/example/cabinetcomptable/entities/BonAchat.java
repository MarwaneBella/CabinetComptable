package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bon_achat")
public class BonAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_ba;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_ba;

    private float total_general;

    @ManyToOne
    @JoinColumn( name = "id_f" )
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "bonAchat")
    private Set<BonAReg> listBonAReg = new HashSet<BonAReg>();

    @OneToMany(mappedBy = "bonAchat")
    private Set<LignBA> listLignBA = new HashSet<LignBA>();

    public BonAchat() {
    }

    public BonAchat(long id_ba, Date date_ba, float total_general) {
        this.id_ba = id_ba;
        this.date_ba = date_ba;
        this.total_general = total_general;
    }

    public BonAchat(Date date_ba, float total_general) {
        this.date_ba = date_ba;
        this.total_general = total_general;
    }


    public long getId_ba() {
        return id_ba;
    }

    public void setId_ba(long id_ba) {
        this.id_ba = id_ba;
    }

    public Date getDate_ba() {
        return date_ba;
    }

    public void setDate_ba(Date date_ba) {
        this.date_ba = date_ba;
    }

    public float getTotal_general() {
        return total_general;
    }

    public void setTotal_general(float total_general) {
        this.total_general = total_general;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Set<BonAReg> getBonsAReg() {
        return listBonAReg;
    }

    public void setBonsAReg(Set<BonAReg> listBonAReg) {
        this.listBonAReg = listBonAReg;
    }
}
