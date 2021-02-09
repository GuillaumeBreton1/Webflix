package hibernate.tableMapping;

public class Scenariste {

    private String nom;

    public Scenariste(String nom) {
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
