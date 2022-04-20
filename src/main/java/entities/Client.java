package entities;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("C")
@Table(name = "clients")
public class Client extends Personne{

    private float bilan;
    private float pv_bilan;
    private float tva_mensuel;
    private float cnss_mensuel;
    private float tva_trimestriel;
    private float cnss_trimestriel;

    @OneToMany(mappedBy="client")
    private Set<BonHonoraire> listBonHonoraire = new HashSet<BonHonoraire>();

    public Client(){
    }

    public Client(long id, String nom, byte image, String email, String tele_portable, String tele_fix, String adresse, String code_postale, String site_web, Date data_de_transaction, float bilan, float pv_bilan, float tva_mensuel, float cnss_mensuel, float tva_trimestriel, float cnss_trimestriel) {
        super(id, nom, image, email, tele_portable, tele_fix, adresse, code_postale, site_web, data_de_transaction);
        this.bilan = bilan;
        this.pv_bilan = pv_bilan;
        this.tva_mensuel = tva_mensuel;
        this.cnss_mensuel = cnss_mensuel;
        this.tva_trimestriel = tva_trimestriel;
        this.cnss_trimestriel = cnss_trimestriel;
    }

    public Client(String nom, byte image, String email, String tele_portable, String tele_fix, String adresse, String code_postale, String site_web, Date data_de_transaction, float bilan, float pv_bilan, float tva_mensuel, float cnss_mensuel, float tva_trimestriel, float cnss_trimestriel) {
        super(nom, image, email, tele_portable, tele_fix, adresse, code_postale, site_web, data_de_transaction);
        this.bilan = bilan;
        this.pv_bilan = pv_bilan;
        this.tva_mensuel = tva_mensuel;
        this.cnss_mensuel = cnss_mensuel;
        this.tva_trimestriel = tva_trimestriel;
        this.cnss_trimestriel = cnss_trimestriel;
    }
    //test :
    public Client(String nom ,String email){
        super(nom,email);
    }

    // end test ;

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

    public float getTva_mensuel() {
        return tva_mensuel;
    }

    public void setTva_mensuel(float tva_mensuel) {
        this.tva_mensuel = tva_mensuel;
    }

    public float getCnss_mensuel() {
        return cnss_mensuel;
    }

    public void setCnss_mensuel(float cnss_mensuel) {
        this.cnss_mensuel = cnss_mensuel;
    }

    public float getTva_trimestriel() {
        return tva_trimestriel;
    }

    public void setTva_trimestriel(float tva_trimestriel) {
        this.tva_trimestriel = tva_trimestriel;
    }

    public float getCnss_trimestriel() {
        return cnss_trimestriel;
    }

    public void setCnss_trimestriel(float cnss_trimestriel) {
        this.cnss_trimestriel = cnss_trimestriel;
    }

    public Set<BonHonoraire> getListBonHonoraire() {
        return listBonHonoraire;
    }

    public void setListBonHonoraire(Set<BonHonoraire> listBonHonoraire) {
        this.listBonHonoraire = listBonHonoraire;
    }
}
