package backend.hibernate.tableMapping;
import javax.persistence.*;

@Entity
@Table(name = "Pays")
public class Pays {

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
