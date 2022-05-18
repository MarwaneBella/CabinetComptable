package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bon_achat")
public class BonAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBa;

    @Column(unique = true)
    private String bonANum;

    private String facBonNum;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateBa;

    private  boolean valide;

    private float totalGeneral;


    @ManyToOne
    @JoinColumn( name = "id_f" )
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "bonAchat")
    private Set<BonAReg> listBonAReg = new HashSet<BonAReg>();

    @OneToMany(mappedBy = "bonAchat",cascade = CascadeType.ALL)
    private Set<LignBA> listLignBA = new HashSet<LignBA>();

    public BonAchat() {
    }

    public BonAchat(long idBa, String bonANum, String facBonNum, Date dateBa, boolean valide, float totalGeneral, Fournisseur fournisseur) {
        this.idBa = idBa;
        this.bonANum = bonANum;
        this.facBonNum = facBonNum;
        this.dateBa = dateBa;
        this.valide = valide;
        this.totalGeneral = totalGeneral;
        this.fournisseur = fournisseur;
    }

    public BonAchat(String bonANum, String facBonNum, Date dateBa, boolean valide, float totalGeneral) {
        this.bonANum = bonANum;
        this.facBonNum = facBonNum;
        this.dateBa = dateBa;
        this.valide = valide;
        this.totalGeneral = totalGeneral;
    }

    public long getIdBa() {
        return idBa;
    }

    public void setIdBa(long idBa) {
        this.idBa = idBa;
    }

    public String getBonANum() {
        return bonANum;
    }

    public void setBonANum(String bonANum) {
        this.bonANum = bonANum;
    }

    public String getFacBonNum() {
        return facBonNum;
    }

    public void setFacBonNum(String facBonNum) {
        this.facBonNum = facBonNum;
    }

    public Date getDateBa() {
        return dateBa;
    }

    public void setDateBa(Date dateBa) {
        this.dateBa = dateBa;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public float getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(float totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }


    public Set<LignBA> getListLignBA() {
        return listLignBA;
    }

    public void setListLignBA(Set<LignBA> listLignBA) {
        this.listLignBA = listLignBA;
    }
}
