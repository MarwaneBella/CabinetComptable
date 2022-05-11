package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFac;

    @Column(unique = true)
    private String facNum;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateFac;

    private float totalHt;
    private float totalTva;
    private float totalTtc;

    @OneToMany(mappedBy = "facture")
    private Set<BonHonoraire> ListbonHonoraire = new HashSet<BonHonoraire>();

    public Facture() {
    }

    public Facture(long idFac, String facNum, Date dateFac, float totalHt, float totalTva, float totalTtc) {
        this.idFac = idFac;
        this.facNum = facNum;
        this.dateFac = dateFac;
        this.totalHt = totalHt;
        this.totalTva = totalTva;
        this.totalTtc = totalTtc;
    }

    public Facture(String facNum, Date dateFac, float totalHt, float totalTva, float totalTtc) {
        this.facNum = facNum;
        this.dateFac = dateFac;
        this.totalHt = totalHt;
        this.totalTva = totalTva;
        this.totalTtc = totalTtc;
    }

    public long getIdFac() {
        return idFac;
    }

    public void setIdFac(long idFac) {
        this.idFac = idFac;
    }

    public String getFacNum() {
        return facNum;
    }

    public void setFacNum(String facNum) {
        this.facNum = facNum;
    }

    public Date getDateFac() {
        return dateFac;
    }

    public void setDateFac(Date dateFac) {
        this.dateFac = dateFac;
    }

    public float getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(float totalHt) {
        this.totalHt = totalHt;
    }

    public float getTotalTva() {
        return totalTva;
    }

    public void setTotalTva(float totalTva) {
        this.totalTva = totalTva;
    }

    public float getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(float totalTtc) {
        this.totalTtc = totalTtc;
    }

    public Set<BonHonoraire> getListbonHonoraire() {
        return ListbonHonoraire;
    }

    public void setListbonHonoraire(Set<BonHonoraire> listbonHonoraire) {
        ListbonHonoraire = listbonHonoraire;
    }
}
