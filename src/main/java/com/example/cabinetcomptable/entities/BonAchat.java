package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bon_achat")
public class BonAchat {

    @Id
    private long id_ba;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_ba;

    private float total_general;

    @ManyToOne
    @JoinColumn( name = "id_f" )
    private Fournisseur fournisseur;

}
