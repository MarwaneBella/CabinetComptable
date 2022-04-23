package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("F")
@Table(name = "fournisseurs")
public class Fournisseur extends Personne{

    @OneToMany(mappedBy="fournisseur")
    private Set<BonAchat> listBonAchat = new HashSet<BonAchat>();

    public Fournisseur() {
      super();
    }

    public Fournisseur(long id, String nom, String image, String email, String tele_portable, String tele_fix, String ville, String adresse, String code_postale, String site_web, Date data_de_transaction) {
        super(id, nom, image, email, tele_portable, tele_fix, ville, adresse, code_postale, site_web, data_de_transaction);
    }
    public Fournisseur( String nom, String image, String email, String tele_portable, String tele_fix, String ville, String adresse, String code_postale, String site_web, Date data_de_transaction) {
        super( nom, image, email, tele_portable, tele_fix, ville, adresse, code_postale, site_web, data_de_transaction);
    }
   // test :


    public Fournisseur(String nom, String email) {
        super(nom, email);
    }

    // end test ;
    public Set<BonAchat> getListBonAchat() {
        return listBonAchat;
    }

    public void setListBonAchat(Set<BonAchat> listBonAchat) {
        this.listBonAchat = listBonAchat;
    }


}
