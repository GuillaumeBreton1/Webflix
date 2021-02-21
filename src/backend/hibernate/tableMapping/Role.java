package backend.hibernate.tableMapping;

public class Role {

    private Integer id;

    private PersonnalitePublique personnalitePublique;

    private Film film;

    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonnalitePublique getPersonnalitePublique() {
        return personnalitePublique;
    }

    public void setPersonnalitePublique(PersonnalitePublique personnalitePublique) {
        this.personnalitePublique = personnalitePublique;
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

}