package hibernate.tableMapping;

public class Role {

    private String nom;
    private Integer idActeur;

    public Role(String nom, Integer idActeur) {
        this.nom = nom;
        this.idActeur = idActeur;
    }

    //GETTERS
    public String getNom() {
        return this.nom;
    }

    public Integer getActeur() {
        return this.idActeur;
    }

    //SETTERS
    public Role setNom(String nom) {
        setNom(nom);
        return this;
    }

    public Role setActeur(PersonnalitePublique acteur) {
        setActeur(acteur);
        return this;
    }
}