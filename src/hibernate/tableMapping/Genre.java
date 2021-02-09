package hibernate.tableMapping;

public class Genre {
    
    private String nom; 

    public Genre(String nom) {
        this.nom = nom;
    }

    //SETTERS
    public Genre setNom(String nom) {
        setNom(nom);
        return this;
    }

    //GETTERS
    public String getNom() {
        return this.nom;
    }

}
