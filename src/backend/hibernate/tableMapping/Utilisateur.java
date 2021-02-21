package backend.hibernate.tableMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    private Integer id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nomDeFamille")
    private String nomDeFamille;

    @Column(name = "motDePasse")
    private String motDePasse;

    @Column(name = "courriel")
    private String courriel;

    @Column(name = "numeroTelephone")
    private String numeroTelephone;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @Column(name = "numeroCivique")
    private Integer numeroCivique;

    @Column(name = "rue")
    private String rue;

    @Column(name = "ville")
    private String ville;

    @Column(name = "province")
    private String province;

    @Column(name = "codePostal")
    private String codePostal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getNumeroCivique() {
        return numeroCivique;
    }

    public void setNumeroCivique(Integer numeroCivique) {
        this.numeroCivique = numeroCivique;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
