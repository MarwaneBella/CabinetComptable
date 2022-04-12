package com.example.cabinetcomptable.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@DiscriminatorValue("F")
@Table(name = "fournisseurs")
public class Fournisseur extends Personne{

    public Fournisseur() {
      super();
    }

    public Fournisseur(long id, String nom, byte image, String email, String tele_portable, String tele_fix, String adresse, String code_postale, String site_web, Date data_de_transaction) {
        super(id, nom, image, email, tele_portable, tele_fix, adresse, code_postale, site_web, data_de_transaction);
    }
    public Fournisseur( String nom, byte image, String email, String tele_portable, String tele_fix, String adresse, String code_postale, String site_web, Date data_de_transaction) {
        super( nom, image, email, tele_portable, tele_fix, adresse, code_postale, site_web, data_de_transaction);
    }


}
