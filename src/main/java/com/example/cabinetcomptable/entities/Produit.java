package com.example.cabinetcomptable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {
    
    @Id
    private String reference;
    private String image;
    private String designation;
    private String description;
    private String type;
    private String marque;
    private float longueur;
    private float largeur;
    private float hauteur;
    private float poids;
    private float surface;
    private float volume;
    private float prix_achat;
    private float prix_vente;
    private float prix_revient;
    private float tva;
    private int quantitie_disponible;
    
    @ManyToOne
    @JoinColumn(name = "id_cat")
    private Categorie categorie ;
    
    @OneToMany(mappedBy = "produit")
    private Set<LignBA> ListLignBA = new HashSet<LignBA>();

    @OneToMany(mappedBy = "produit")
    private Set<LignBH> ListLignBH = new HashSet<LignBH>();

    public Produit() {
    }

    public Produit(String reference, String image, String designation, String description,String type ,String marque, float longueur, float largeur, float hauteur, float poids, float surface, float volume, float prix_achat, float prix_vente, float prix_revient, float tva, int quantitie_disponible, Categorie categorie) {
        this.reference = reference;
        this.image = image;
        this.designation = designation;
        this.description = description;
        this.type =type;
        this.marque = marque;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.poids = poids;
        this.surface = surface;
        this.volume = volume;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.prix_revient = prix_revient;
        this.tva = tva;
        this.quantitie_disponible = quantitie_disponible;
        this.categorie = categorie;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public float getLongueur() {
        return longueur;
    }

    public void setLongueur(float longueur) {
        this.longueur = longueur;
    }

    public float getlargeur() {
        return largeur;
    }

    public void setlargeur(float largeur) {
        this.largeur = largeur;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(float prix_achat) {
        this.prix_achat = prix_achat;
    }

    public float getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(float prix_vente) {
        this.prix_vente = prix_vente;
    }

    public float getPrix_revient() {
        return prix_revient;
    }

    public void setPrix_revient(float prix_revient) {
        this.prix_revient = prix_revient;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public int getQuantitie_disponible() {
        return quantitie_disponible;
    }

    public void setQuantitie_disponible(int quantitie_disponible) {
        this.quantitie_disponible = quantitie_disponible;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @JsonIgnore
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
