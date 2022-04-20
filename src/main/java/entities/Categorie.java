package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_cat;
    private String nom_cat;

    @OneToMany(mappedBy = "categorie")
    private Set<Produit> listProduit = new HashSet<>();


    public Categorie() {
    }

    public Categorie(long id_cat, String nom_cat) {
        this.id_cat = id_cat;
        this.nom_cat = nom_cat;
    }

    public Categorie(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public long getId_cat() {
        return id_cat;
    }

    public void setId_cat(long id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public Set<Produit> getListProduit() {
        return listProduit;
    }

    public void setListProduit(Set<Produit> listProduit) {
        this.listProduit = listProduit;
    }
}
