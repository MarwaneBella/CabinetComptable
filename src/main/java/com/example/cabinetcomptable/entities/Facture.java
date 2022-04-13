package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_fac;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_fac;

    private float total_ht;
    private float total_tva;
    private float total_ttc;

    @OneToMany(mappedBy = "facture")
    private Set<BonHonoraire> ListbonHonoraire = new HashSet<BonHonoraire>();




}
