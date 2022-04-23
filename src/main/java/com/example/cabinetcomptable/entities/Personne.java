package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PersonneType")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String nom;
    private String image;
    private String email;
    private String tele_portable;
    private String tele_fix;
    private String ville;
    private String adresse;
    private String code_postale;
    private String site_web;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date data_de_transaction;

    public Personne() {
    }

    public Personne(long id, String nom, String image, String email, String tele_portable, String tele_fix,String ville, String adresse, String code_postale, String site_web, Date data_de_transaction) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.email = email;
        this.tele_portable = tele_portable;
        this.tele_fix = tele_fix;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postale = code_postale;
        this.site_web = site_web;
        this.data_de_transaction = data_de_transaction;
    }
    public Personne( String nom, String image, String email, String tele_portable, String tele_fix, String ville, String adresse, String code_postale, String site_web, Date data_de_transaction) {
        this.nom = nom;
        this.image = image;
        this.email = email;
        this.tele_portable = tele_portable;
        this.tele_fix = tele_fix;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postale = code_postale;
        this.site_web = site_web;
        this.data_de_transaction = data_de_transaction;
    }
    // test :
    public Personne(String nom, String email) {
        this.nom =nom;
        this.email=email;
    }
    // test end ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele_portable() {
        return tele_portable;
    }

    public void setTele_portable(String tele_portable) {
        this.tele_portable = tele_portable;
    }

    public String getTele_fix() {
        return tele_fix;
    }

    public void setTele_fix(String tele_fix) {
        this.tele_fix = tele_fix;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postale() {
        return code_postale;
    }

    public void setCode_postale(String code_postale) {
        this.code_postale = code_postale;
    }

    public String getSite_web() {
        return site_web;
    }

    public void setSite_web(String site_web) {
        this.site_web = site_web;
    }

    public Date getData_de_transaction() {
        return data_de_transaction;
    }

    public void setData_de_transaction(Date data_de_transaction) {
        this.data_de_transaction = data_de_transaction;
    }

}
