package com.example.cabinetcomptable.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "bon_honoraire")
public class BonHonoraire {

    @Id
    private long id_bh;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_bh;

    private float total_general;

    @ManyToOne
    @JoinColumn( name = "id_c" )
    private Client client;


    public BonHonoraire() {
    }

    public BonHonoraire(long id_bh, Date date_bh, float total_general, Client client) {
        this.id_bh = id_bh;
        this.date_bh = date_bh;
        this.total_general = total_general;
        this.client = client;
    }

    public BonHonoraire(Date date_bh, float total_general, Client client) {
        this.date_bh = date_bh;
        this.total_general = total_general;
        this.client = client;
    }

    public long getId_bh() {
        return id_bh;
    }

    public void setId_bh(long id_bh) {
        this.id_bh = id_bh;
    }

    public Date getDate_bh() {
        return date_bh;
    }

    public void setDate_bh(Date date_bh) {
        this.date_bh = date_bh;
    }

    public float getTotal_general() {
        return total_general;
    }

    public void setTotal_general(float total_general) {
        this.total_general = total_general;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
