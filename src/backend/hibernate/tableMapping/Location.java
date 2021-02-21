package backend.hibernate.tableMapping;

import java.util.Date;

public class Location {
    
    private Integer id;
    private Date dateLocation;
    private Date dateRetour;
    private Client client;
    private Exemplaire exemplaire;
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

    
