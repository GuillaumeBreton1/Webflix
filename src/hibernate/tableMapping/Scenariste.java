package hibernate.tableMapping;
import javax.persistence.*;

@Entity
@Table(name = "Scenariste")
public class Scenariste {

    @Id
    private Integer id;

    @Column(name = "nom")
    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}