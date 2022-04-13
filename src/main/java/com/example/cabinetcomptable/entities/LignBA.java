package com.example.cabinetcomptable.entities;

import javax.persistence.*;

@Entity
@Table(name = "lign_ba")
public class LignBA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_lign_a;
    private int quantite;
    private float montant;
    @ManyToOne
    @JoinColumn( name = "id_ba" )
    private BonAchat bonAchat;


    public LignBA() {
    }

    public LignBA(long id_lign_a, int quantite, float montant, BonAchat bonAchat) {
        this.id_lign_a = id_lign_a;
        this.quantite = quantite;
        this.montant = montant;
        this.bonAchat = bonAchat;
    }

    public LignBA(int quantite, float montant, BonAchat bonAchat) {
        this.quantite = quantite;
        this.montant = montant;
        this.bonAchat = bonAchat;
    }

    public long getid_lign_a() {
        return id_lign_a;
    }

    public void setid_lign_a(long id_lign_a) {
        this.id_lign_a = id_lign_a;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
}
