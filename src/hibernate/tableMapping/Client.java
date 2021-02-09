package hibernate.tableMapping;

import java.sql.Date;

public class Client extends Utilisateur {

    private Forfait forfait;
    private CarteCredit carteCredit;

    public Client(Integer id, String nomDeFamille, String prenom, String motDePasse, String courriel, 
                  String numeroTelephone,Date dateNaissance, Adresse adresse, Forfait forfait,
                  CarteCredit carteCredit) {

        super(id, nomDeFamille, prenom, motDePasse, courriel, numeroTelephone, dateNaissance, adresse);
        this.forfait = forfait; 
        this.carteCredit = carteCredit; 

    }

    //GETTERS
    public Forfait getForfait() {
        return this.forfait;
    }


    public CarteCredit getCarteCredit() {
        return this.carteCredit;
    }

    // SETTERS 
    public Client setForfait(Forfait forfait) {
        setForfait(forfait);
        return this;
    }

    public Client setCarteCredit(CarteCredit carteCredit) {
        setCarteCredit(carteCredit);
        return this;
    }


}
