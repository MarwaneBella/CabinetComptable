package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reglement_client")
public class ReglementClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegC;

    @Column(unique = true)
    private String codeRF;
    private String modePaymant;
    private boolean status;
    private double avance;
    private double reste;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date datePayment;

    @ManyToOne
    @JoinColumn(name = "id_reg_c")
    private BonHonoraire bonHonoraire;

    public ReglementClient() {
    }

    public ReglementClient(long idRegC, String codeRF, String modePaymant, boolean status, double avance, double reste, Date datePayment) {
        this.idRegC = idRegC;
        this.codeRF = codeRF;
        this.modePaymant = modePaymant;
        this.status = status;
        this.avance = avance;
        this.reste = reste;
        this.datePayment = datePayment;
    }

    public ReglementClient(String codeRF, String modePaymant, boolean status, double avance, double reste, Date datePayment) {
        this.codeRF = codeRF;
        this.modePaymant = modePaymant;
        this.status = status;
        this.avance = avance;
        this.reste = reste;
        this.datePayment = datePayment;
    }

    public long getIdRegC() {
        return idRegC;
    }

    public void setIdRegC(long idRegC) {
        this.idRegC = idRegC;
    }

    public String getCodeRF() {
        return codeRF;
    }

    public void setCodeRF(String codeRF) {
        this.codeRF = codeRF;
    }

    public String getModePaymant() {
        return modePaymant;
    }

    public void setModePaymant(String modePaymant) {
        this.modePaymant = modePaymant;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    @JsonIgnore
    public BonHonoraire getBonHonoraire() {
        return bonHonoraire;
    }

    public void setBonHonoraire(BonHonoraire bonHonoraire) {
        this.bonHonoraire = bonHonoraire;
    }
}
