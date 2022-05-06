package com.example.cabinetcomptable.entities;

import javax.persistence.*;

@Entity
@Table(name = "lign_bh")
public class LignBH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_lign_h;
    private int quantite;
    private float montant;

    @ManyToOne
    @JoinColumn( name = "id_bh" )
    private BonHonoraire bonHonoraire;

    @ManyToOne
    @JoinColumn(name ="reference")
    private Produit produit;

    public LignBH() {
    }

    public LignBH(long id_lign_h, int quantite, float montant, BonHonoraire bonHonoraire) {
        this.id_lign_h = id_lign_h;
        this.quantite = quantite;
        this.montant = montant;
        this.bonHonoraire = bonHonoraire;
    }

    public LignBH(int quantite, float montant, BonHonoraire bonHonoraire) {
        this.quantite = quantite;
        this.montant = montant;
        this.bonHonoraire = bonHonoraire;
    }

    public long getId_lign_h() {
        return id_lign_h;
    }

    public void setId_lign_h(long id_lign_h) {
        this.id_lign_h = id_lign_h;
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

    public BonHonoraire getBonHonoraire() {
        return bonHonoraire;
    }

    public void setBonHonoraire(BonHonoraire bonHonoraire) {
        this.bonHonoraire = bonHonoraire;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
