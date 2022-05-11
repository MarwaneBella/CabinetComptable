package com.example.cabinetcomptable.entities;

import javax.persistence.*;

@Entity
@Table(name = "lign_bh")
public class LignBH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLignH;
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

    public LignBH(long idLignH, int quantite, float montant) {
        this.idLignH = idLignH;
        this.quantite = quantite;
        this.montant = montant;
    }

    public long getIdLignH() {
        return idLignH;
    }

    public void setIdLignH(long idLignH) {
        this.idLignH = idLignH;
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
