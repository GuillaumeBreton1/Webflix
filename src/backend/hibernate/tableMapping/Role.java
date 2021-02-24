package backend.hibernate.tableMapping;

public class Role {

    private Integer id;
    private PersonnalitePublique acteur;
    private Film film;
    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonnalitePublique getActeur() {
        return acteur;
    }

    public void setActeur(PersonnalitePublique acteur) {
        this.acteur = acteur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString(){
        return acteur.getNom() + " : " + nom;
    }

}