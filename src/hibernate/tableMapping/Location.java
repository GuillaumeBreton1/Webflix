package hibernate.tableMapping;

import java.sql.Date;

public class Location {
    
    private Date dateLocation;
    private Client client; 
    private Exemplaire exemplaire; 
    private boolean locationActive; 
    private Date dateRetour; 


    public Location(Date dateLocation, Client client, Exemplaire exemplaire, boolean locationActive, Date dateRetour) {
        this.dateLocation = dateLocation;
        this.client = client;
        this.exemplaire = exemplaire;
        this.locationActive = locationActive;
        this.dateRetour = dateRetour;
    }

    //GETTERS
    public Date getDateLocationt() {
        return this.dateLocation;
    }


    public Client getClient() {
        return this.client;
    }


    public Exemplaire getExemplaire() {
        return this.exemplaire;
    }


    public boolean isLocationActive() {
        return this.locationActive;
    }

    public boolean getLocationActive() {
        return this.locationActive;
    }


    public Date getDateRetour() {
        return this.dateRetour;
    }

    //SETTERS 
    public Location setDateLocation(Date datePret) {
        setDateLocation(datePret);
        return this;
    }

    public Location setClient(Client client) {
        setClient(client);
        return this;
    }

    public Location setExemplaire(Exemplaire exemplaire) {
        setExemplaire(exemplaire);
        return this;
    }

    public Location setLocationActive(boolean locationActive) {
        setLocationActive(locationActive);
        return this;
    }

    public Location setDateRetour(Date dateRetour) {
        setDateRetour(dateRetour);
        return this;
    }

}

    
