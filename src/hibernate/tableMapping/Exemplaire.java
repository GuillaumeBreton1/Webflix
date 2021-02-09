package hibernate.tableMapping;

import java.sql.Date;

public class Exemplaire {

    private Utilisateur utilisateur;
    private Date dateAchat;


    public Exemplaire(Utilisateur utilisateur, Date dateAchat) {
        this.utilisateur = utilisateur;
        this.dateAchat = dateAchat;
    }

    //GETTERS
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }


    public Date getDateAchat() {
        return this.dateAchat;
    }

    //SETTERS 
    public Exemplaire setUtilisateur(Utilisateur utilisateur) {
        setUtilisateur(utilisateur);
        return this;
    }

    public Exemplaire setDateAchat(Date dateAchat) {
        setDateAchat(dateAchat);
        return this;
    }

}
