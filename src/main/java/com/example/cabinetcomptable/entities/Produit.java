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
    private float prixAchat;
    private float prixVente;
    private float prixRevient;
    private float tva;
    private int quantitieDisponible;
    
    @ManyToOne
    @JoinColumn(name = "id_cat")
    private Categorie categorie ;
    
    @OneToMany(mappedBy = "produit")
    private Set<LignBA> ListLignBA = new HashSet<LignBA>();

    @OneToMany(mappedBy = "produit")
    private Set<LignBH> ListLignBH = new HashSet<LignBH>();

    public Produit() {
    }

    public Produit(String reference, String image, String designation, String description, String type, String marque, float longueur, float largeur, float hauteur, float poids, float surface, float volume, float prixAchat, float prixVente, float prixRevient, float tva, int quantitieDisponible) {
        this.reference = reference;
        this.image = image;
        this.designation = designation;
        this.description = description;
        this.type = type;
        this.marque = marque;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.poids = poids;
        this.surface = surface;
        this.volume = volume;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.prixRevient = prixRevient;
        this.tva = tva;
        this.quantitieDisponible = quantitieDisponible;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public float getLargeur() {
        return largeur;
    }

    public void setLargeur(float largeur) {
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

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public float getPrixRevient() {
        return prixRevient;
    }

    public void setPrixRevient(float prixRevient) {
        this.prixRevient = prixRevient;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public int getQuantitieDisponible() {
        return quantitieDisponible;
    }

    public void setQuantitieDisponible(int quantitieDisponible) {
        this.quantitieDisponible = quantitieDisponible;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    //@JsonIgnore
    public Categorie getCategorie() {
        return categorie;
    }


}
