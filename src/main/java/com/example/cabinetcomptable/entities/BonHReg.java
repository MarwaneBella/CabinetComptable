package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bon_ho_Reg")
public class BonHReg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_bh_reg;
    private float montant;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_payment;

    @ManyToOne
    @JoinColumn(name = "id_bh")
    private BonHonoraire bonHonoraire;

    @ManyToOne
    @JoinColumn(name = "id_reg_c")
    private ReglementClient reglementClient;


    public BonHReg() {
    }

    public BonHReg(long id_bh_reg, float montant, Date date_payment, BonHonoraire bonHonoraire) {
        this.id_bh_reg = id_bh_reg;
        this.montant = montant;
        this.date_payment = date_payment;
        this.bonHonoraire = bonHonoraire;
    }

    public BonHReg(float montant, Date date_payment, BonHonoraire bonHonoraire) {
        this.montant = montant;
        this.date_payment = date_payment;
        this.bonHonoraire = bonHonoraire;
    }

    public long getId_bh_reg() {
        return id_bh_reg;
    }

    public void setId_bh_reg(long id_bh_reg) {
        this.id_bh_reg = id_bh_reg;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDate_payment() {
        return date_payment;
    }

    public void setDate_payment(Date date_payment) {
        this.date_payment = date_payment;
    }

    public BonHonoraire getBonHonoraire() {
        return bonHonoraire;
    }

    public void setBonHonoraire(BonHonoraire bonHonoraire) {
        this.bonHonoraire = bonHonoraire;
    }
}
