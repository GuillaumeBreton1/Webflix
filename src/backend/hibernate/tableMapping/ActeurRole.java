package backend.hibernate.tableMapping;

import javax.persistence.*;

@Entity
@Table(name = "ActeurRole")
public class ActeurRole {

    @ManyToOne
    @JoinColumn(name = "idActeur")
    private PersonnalitePublique acteur;

    @OneToOne
    @JoinColumn(name = "idRole")
    private Role role;

    public PersonnalitePublique getActeur() {
        return acteur;
    }

    public void setActeur(PersonnalitePublique acteur) {
        this.acteur = acteur;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
