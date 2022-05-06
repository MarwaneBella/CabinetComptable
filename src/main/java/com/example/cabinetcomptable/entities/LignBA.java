package com.example.cabinetcomptable.entities;

import javax.persistence.*;

@Entity
@Table(name = "lign_ba")
public class LignBA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_lign_a;
    private int quantite;
    private float montant_ttc;
    private float prix_unitaire;
    @ManyToOne
    @JoinColumn( name = "id_ba" )
    private BonAchat bonAchat;

    @ManyToOne
    @JoinColumn(name ="reference")
    private Produit produit;


    public LignBA() {
    }

    public LignBA(long id_lign_a, int quantite, float montant_ttc, float prix_unitaire, BonAchat bonAchat, Produit produit) {
        this.id_lign_a = id_lign_a;
        this.quantite = quantite;
        this.montant_ttc = montant_ttc;
        this.prix_unitaire = prix_unitaire;
        this.bonAchat = bonAchat;
        this.produit = produit;
    }

    public LignBA(int quantite, float montant_ttc, float prix_unitaire, BonAchat bonAchat, Produit produit) {
        this.quantite = quantite;
        this.montant_ttc = montant_ttc;
        this.prix_unitaire = prix_unitaire;
        this.bonAchat = bonAchat;
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getMontant_ttc() {
        return montant_ttc;
    }

    public void setMontant_ttc(float montant_ttc) {
        this.montant_ttc = montant_ttc;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public long getId_lign_a() {
        return id_lign_a;
    }

    public void setId_lign_a(long id_lign_a) {
        this.id_lign_a = id_lign_a;
    }

    public BonAchat getBonAchat() {
        return bonAchat;
    }

    public void setBonAchat(BonAchat bonAchat) {
        this.bonAchat = bonAchat;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
