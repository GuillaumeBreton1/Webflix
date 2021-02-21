package backend.hibernate.tableMapping;

public class ActeurRole {

    private PersonnalitePublique acteur;
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
