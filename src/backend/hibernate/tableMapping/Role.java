package backend.hibernate.tableMapping;
import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idActeur")
    private PersonnalitePublique personnalitePublique;

    @ManyToOne
    @JoinColumn(name = "idFilm")
    private Film film;

    @Column(name = "nom")
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