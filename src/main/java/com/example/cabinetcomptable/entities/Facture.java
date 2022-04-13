package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_fac;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_fac;

    private float total_ht;
    private float total_tva;
    private float total_ttc;

    @OneToMany(mappedBy = "facture")
    private Set<BonHonoraire> ListbonHonoraire = new HashSet<BonHonoraire>();

    public Facture() {
    }

    public Facture(long id_fac, Date date_fac, float total_ht, float total_tva, float total_ttc) {
        this.id_fac = id_fac;
        this.date_fac = date_fac;
        this.total_ht = total_ht;
        this.total_tva = total_tva;
        this.total_ttc = total_ttc;
    }

    public Facture(Date date_fac, float total_ht, float total_tva, float total_ttc) {
        this.date_fac = date_fac;
        this.total_ht = total_ht;
        this.total_tva = total_tva;
        this.total_ttc = total_ttc;
    }

    public long getId_fac() {
        return id_fac;
    }

    public void setId_fac(long id_fac) {
        this.id_fac = id_fac;
    }

    public Date getDate_fac() {
        return date_fac;
    }

    public void setDate_fac(Date date_fac) {
        this.date_fac = date_fac;
    }

    public float getTotal_ht() {
        return total_ht;
    }

    public void setTotal_ht(float total_ht) {
        this.total_ht = total_ht;
    }

    public float getTotal_tva() {
        return total_tva;
    }

    public void setTotal_tva(float total_tva) {
        this.total_tva = total_tva;
    }

    public float getTotal_ttc() {
        return total_ttc;
    }

    public void setTotal_ttc(float total_ttc) {
        this.total_ttc = total_ttc;
    }

    public Set<BonHonoraire> getListbonHonoraire() {
        return ListbonHonoraire;
    }

    public void setListbonHonoraire(Set<BonHonoraire> listbonHonoraire) {
        ListbonHonoraire = listbonHonoraire;
    }
}
