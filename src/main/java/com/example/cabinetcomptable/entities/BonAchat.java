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

    private float totalGeneral;


    @ManyToOne
    @JoinColumn( name = "id_f" )
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "bonAchat")
    private Set<BonAReg> listBonAReg = new HashSet<BonAReg>();

    @OneToMany(mappedBy = "bonAchat")
    private Set<LignBA> listLignBA = new HashSet<LignBA>();

    public BonAchat() {
    }

    public BonAchat(long idBa, String bonANum, String facBonNum, Date dateBa, float totalGeneral) {
        this.idBa = idBa;
        this.bonANum = bonANum;
        this.facBonNum = facBonNum;
        this.dateBa = dateBa;
        this.totalGeneral = totalGeneral;
    }

    public BonAchat(String bonANum, String facBonNum, Date dateBa, float totalGeneral) {
        this.bonANum = bonANum;
        this.facBonNum = facBonNum;
        this.dateBa = dateBa;
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

    public Set<BonAReg> getBonsAReg() {
        return listBonAReg;
    }

    public void setBonsAReg(Set<BonAReg> listBonAReg) {
        this.listBonAReg = listBonAReg;
    }
}
