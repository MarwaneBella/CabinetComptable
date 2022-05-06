package com.example.cabinetcomptable.entities;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client extends Personne{

    private float bilan;
    private float pv_bilan;
    private String regime;
    private float r_tva;
    private float r_cnss;

    @OneToMany(mappedBy="client")
    private Set<BonHonoraire> listBonHonoraire = new HashSet<BonHonoraire>();

    public Client(){
    }

    public Client(long id, String nom, String image, String email, String tele_portable, String tele_fix, String ville, String adresse, String code_postale, String site_web, String ifi, String ice, String tp, String cnss, String rc, Date data_de_transaction, float bilan, float pv_bilan, String regime, float r_tva, float r_cnss) {
        super(id, nom, image, email, tele_portable, tele_fix, ville, adresse, code_postale, site_web, ifi, ice, tp, cnss, rc, data_de_transaction);
        this.bilan = bilan;
        this.pv_bilan = pv_bilan;
        this.regime = regime;
        this.r_tva = r_tva;
        this.r_cnss = r_cnss;
    }

    public Client(String nom, String image, String email, String tele_portable, String tele_fix, String ville, String adresse, String code_postale, String site_web, String ifi, String ice, String tp, String cnss, String rc, Date data_de_transaction, float bilan, float pv_bilan, String regime, float r_tva, float r_cnss) {
        super(nom, image, email, tele_portable, tele_fix, ville, adresse, code_postale, site_web, ifi, ice, tp, cnss, rc, data_de_transaction);
        this.bilan = bilan;
        this.pv_bilan = pv_bilan;
        this.regime = regime;
        this.r_tva = r_tva;
        this.r_cnss = r_cnss;
    }

    public float getBilan() {
        return bilan;
    }

    public void setBilan(float bilan) {
        this.bilan = bilan;
    }

    public float getPv_bilan() {
        return pv_bilan;
    }

    public void setPv_bilan(float pv_bilan) {
        this.pv_bilan = pv_bilan;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public float getR_tva() {
        return r_tva;
    }

    public void setR_tva(float r_tva) {
        this.r_tva = r_tva;
    }

    public float getR_cnss() {
        return r_cnss;
    }

    public void setR_cnss(float r_cnss) {
        this.r_cnss = r_cnss;
    }
}
