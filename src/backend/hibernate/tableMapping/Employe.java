package backend.hibernate.tableMapping;

import javax.persistence.*;

@Entity
@Table(name = "Employe")
public class Employe {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    private Utilisateur utilisateur;

    @Column(name = "matricule")
    private Integer matricule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }
}
