package com.example.cabinetcomptable.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "bon_honoraire")
public class BonHonoraire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBh;

    @Column(unique = true)
    private String bonHNum;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateBh;

    private double totalGeneral;

    @ManyToOne
    @JoinColumn( name = "id_c" )
    private Client client;

    @ManyToOne
    @JoinColumn( name = "id_fac" )
    private Facture facture;

    @OneToMany(mappedBy = "bonHonoraire")
    private Set<BonHReg> listBonHReg = new HashSet<BonHReg>();

    @OneToMany(mappedBy = "bonHonoraire")
    private Set<LignBH>  listLignBh= new HashSet<LignBH>();



    public BonHonoraire() {
    }

    public BonHonoraire(long idBh, String bonHNum, Date dateBh, double totalGeneral) {
        this.idBh = idBh;
        this.bonHNum = bonHNum;
        this.dateBh = dateBh;
        this.totalGeneral = totalGeneral;
    }

    public long getIdBh() {
        return idBh;
    }

    public void setIdBh(long idBh) {
        this.idBh = idBh;
    }

    public String getBonHNum() {
        return bonHNum;
    }

    public void setBonHNum(String bonHNum) {
        this.bonHNum = bonHNum;
    }

    public Date getDateBh() {
        return dateBh;
    }

    public void setDateBh(Date dateBh) {
        this.dateBh = dateBh;
    }

    public double getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(double totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Set<BonHReg> getListBonHReg() {
        return listBonHReg;
    }

    public void setListBonHReg(Set<BonHReg> listBonHReg) {
        this.listBonHReg = listBonHReg;
    }

    public Set<LignBH> getListLignBh() {
        return listLignBh;
    }

    public void setListLignBh(Set<LignBH> listLignBh) {
        this.listLignBh = listLignBh;
    }
}
