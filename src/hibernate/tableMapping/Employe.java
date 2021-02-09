package hibernate.tableMapping;

import java.sql.Date;

public class Employe extends Utilisateur {

    public Employe(int id, String nomDeFamille, String prenom, String motDePasse, String courriel, 
                   String numeroTelephone, Date dateNaissance, Adresse adresse) {
        super(id, nomDeFamille, prenom, motDePasse, courriel, numeroTelephone, dateNaissance, adresse);
    }
    
}
