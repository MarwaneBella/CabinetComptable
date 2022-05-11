package com.example.cabinetcomptable.entities;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
@EntityListeners(AuditingEntityListener.class)
public class Client extends Personne{

    @Column(unique = true)
    private String codeC;

    private float bilan;
    private float pvBilan;
    private String regime;
    private float rTva;
    private float rCnss;

    @OneToMany(mappedBy="client")
    private Set<BonHonoraire> listBonHonoraire = new HashSet<BonHonoraire>();

    public Client(){
    }

    public Client(long id, String nom, String image, String email, String telePortable, String teleFix, String ville, String adresse, String codePostale, String siteWeb, String ifi, String ice, String tp, String cnss, String rc, Date dateTransaction, String codeC, float bilan, float pvBilan, String regime, float rTva, float rCnss) {
        super(id, nom, image, email, telePortable, teleFix, ville, adresse, codePostale, siteWeb, ifi, ice, tp, cnss, rc, dateTransaction);
        this.codeC = codeC;
        this.bilan = bilan;
        this.pvBilan = pvBilan;
        this.regime = regime;
        this.rTva = rTva;
        this.rCnss = rCnss;
    }

    public Client(String nom, String image, String email, String telePortable, String teleFix, String ville, String adresse, String codePostale, String siteWeb, String ifi, String ice, String tp, String cnss, String rc, Date dateTransaction, String codeC, float bilan, float pvBilan, String regime, float rTva, float rCnss) {
        super(nom, image, email, telePortable, teleFix, ville, adresse, codePostale, siteWeb, ifi, ice, tp, cnss, rc, dateTransaction);
        this.codeC = codeC;
        this.bilan = bilan;
        this.pvBilan = pvBilan;
        this.regime = regime;
        this.rTva = rTva;
        this.rCnss = rCnss;
    }

    public String getCodeC() {
        return codeC;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC;
    }

    public float getBilan() {
        return bilan;
    }

    public void setBilan(float bilan) {
        this.bilan = bilan;
    }

    public float getPvBilan() {
        return pvBilan;
    }

    public void setPvBilan(float pvBilan) {
        this.pvBilan = pvBilan;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public float getrTva() {
        return rTva;
    }

    public void setrTva(float rTva) {
        this.rTva = rTva;
    }

    public float getrCnss() {
        return rCnss;
    }

    public void setrCnss(float rCnss) {
        this.rCnss = rCnss;
    }
}
