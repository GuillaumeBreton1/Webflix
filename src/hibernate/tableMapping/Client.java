package hibernate.tableMapping;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idForfait")
    private Forfait forfait;

    @OneToOne
    @JoinColumn(name = "numeroCarteCredit")
    private CarteCredit carteCredit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Forfait getForfait() {
        return forfait;
    }

    public void setForfait(Forfait forfait) {
        this.forfait = forfait;
    }

    public CarteCredit getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(CarteCredit carteCredit) {
        this.carteCredit = carteCredit;
    }
}
