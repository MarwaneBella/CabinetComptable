package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="bon_Ach_Reg")
public class BonAReg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_ba_reg;
    private float montant;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_payment;

    @ManyToOne
    @JoinColumn( name = "id_ba" )
    private BonAchat bonAchat;

    @ManyToOne
    @JoinColumn( name = "id_reg_f" )
    private BonAchat bonAreg;

    public BonAReg() {
    }

    public BonAReg(long id_ba_reg, float montant, Date date_payment, BonAchat bonAchat, BonAchat bonAreg) {
        this.id_ba_reg = id_ba_reg;
        this.montant = montant;
        this.date_payment = date_payment;
        this.bonAchat = bonAchat;
        this.bonAreg = bonAreg;
    }

    public BonAReg(float montant, Date date_payment, BonAchat bonAchat, BonAchat bonAreg) {
        this.montant = montant;
        this.date_payment = date_payment;
        this.bonAchat = bonAchat;
        this.bonAreg = bonAreg;
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

    public BonAchat getBonAchat() {
        return bonAchat;
    }

    public void setBonAchat(BonAchat bonAchat) {
        this.bonAchat = bonAchat;
    }

    public long getId_ba_reg() {
        return id_ba_reg;
    }

    public void setId_ba_reg(long id_ba_reg) {
        this.id_ba_reg = id_ba_reg;
    }

    public BonAchat getBonAreg() {
        return bonAreg;
    }

    public void setBonAreg(BonAchat bonAreg) {
        this.bonAreg = bonAreg;
    }
}
