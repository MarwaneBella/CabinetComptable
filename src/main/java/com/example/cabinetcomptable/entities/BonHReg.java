package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bon_ho_Reg")
public class BonHReg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBhReg;
    private float montant;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date datePayment;

    @ManyToOne
    @JoinColumn(name = "id_bh")
    private BonHonoraire bonHonoraire;

    @ManyToOne
    @JoinColumn(name = "id_reg_c")
    private ReglementClient reglementClient;


    public BonHReg() {
    }

    public BonHReg(long idBhReg, float montant, Date datePayment) {
        this.idBhReg = idBhReg;
        this.montant = montant;
        this.datePayment = datePayment;
    }

    public long getIdBhReg() {
        return idBhReg;
    }

    public void setIdBhReg(long idBhReg) {
        this.idBhReg = idBhReg;
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

    public BonHonoraire getBonHonoraire() {
        return bonHonoraire;
    }

    public void setBonHonoraire(BonHonoraire bonHonoraire) {
        this.bonHonoraire = bonHonoraire;
    }

    public ReglementClient getReglementClient() {
        return reglementClient;
    }

    public void setReglementClient(ReglementClient reglementClient) {
        this.reglementClient = reglementClient;
    }
}
