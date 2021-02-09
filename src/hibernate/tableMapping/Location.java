package hibernate.tableMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Location")
public class Location {
    
    @Id
    private Integer id;

    @Column(name = "dateLocation")
    private Date dateLocation;

    @Column(name = "dateRetour")
    private Date dateRetour;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idExemplaire")
    private Exemplaire exemplaire;

    @Column(name = "etatLocation")
    private Integer etatLocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(Date dateLocation) {
        this.dateLocation = dateLocation;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Integer getEtatLocation() {
        return etatLocation;
    }

    public void setEtatLocation(Integer etatLocation) {
        this.etatLocation = etatLocation;
    }
}

    
