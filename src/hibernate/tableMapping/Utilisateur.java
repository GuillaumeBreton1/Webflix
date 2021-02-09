package hibernate.tableMapping;

import java.sql.Date;

public class Utilisateur {
    
    private Integer id;
    private String nomDeFamille; 
    private String prenom; 
    private String motDePasse; 
    private String courriel; 
    private String numeroTelephone; 
    private Date dateNaissance;


    public Utilisateur(Integer id, String nomDeFamille, String prenom, String motDePasse, String courriel, 
                       String numeroTelephone, Date dateNaissance, Adresse adresse) {

        this.id = id;
        this.nomDeFamille = nomDeFamille;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.courriel = courriel;
        this.numeroTelephone = numeroTelephone;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    // GETTERS
    public Integer getId() {
        return this.id;
    }

    public String getNomDeFamille() {
        return this.nomDeFamille;
    }


    public String getPrenom() {
        return this.prenom;
    }


    public String getMotDePasse() {
        return this.motDePasse;
    }


    public String getCourriel() {
        return this.courriel;
    }


    public String getNumeroTelephone() {
        return this.numeroTelephone;
    }


    public Date getDateNaissance() {
        return this.dateNaissance;
    }


    public Adresse getAdresse() {
        return this.adresse;
    }

    // SETTERS 
    public Utilisateur setId(Integer id) {
        this.id = id;
        return this;
    }

    public Utilisateur setNomDeFamille(String nomDeFamille) {
        setNomDeFamille(nomDeFamille);
        return this;
    }

    public Utilisateur setPrenom(String prenom) {
        setPrenom(prenom);
        return this;
    }

    public Utilisateur setMotDePasse(String motDePasse) {
        setMotDePasse(motDePasse);
        return this;
    }

    public Utilisateur setCourriel(String courriel) {
        setCourriel(courriel);
        return this;
    }

    public Utilisateur setNumeroTelephone(String numeroTelephone) {
        setNumeroTelephone(numeroTelephone);
        return this;
    }

    public Utilisateur setDateNaissance(Date dateNaissance) {
        setDateNaissance(dateNaissance);
        return this;
    }

    public Utilisateur setAdresse(Adresse adresse) {
        setAdresse(adresse);
        return this;
    }
}
