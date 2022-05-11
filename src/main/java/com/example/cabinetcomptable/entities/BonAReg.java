package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="bon_Ach_Reg")
public class BonAReg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBaReg;
    private float montant;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date datePayment;

    @ManyToOne
    @JoinColumn( name = "id_ba" )
    private BonAchat bonAchat;

    @ManyToOne
    @JoinColumn( name = "id_reg_f" )
    private BonAchat bonAreg;

    public BonAReg() {
    }

    public BonAReg(long idBaReg, float montant, Date datePayment) {
        this.idBaReg = idBaReg;
        this.montant = montant;
        this.datePayment = datePayment;
    }

    public BonAReg(float montant, Date datePayment) {
        this.montant = montant;
        this.datePayment = datePayment;
    }

    public long getIdBaReg() {
        return idBaReg;
    }

    public void setIdBaReg(long idBaReg) {
        this.idBaReg = idBaReg;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public BonAchat getBonAreg() {
        return bonAreg;
    }

    public void setBonAreg(BonAchat bonAreg) {
        this.bonAreg = bonAreg;
    }
}
