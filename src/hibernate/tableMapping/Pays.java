package hibernate.tableMapping;

public class Pays {

    private String nom;

    public Pays() {}

    public Pays(String nom) {
        this.nom = nom;
    }

    //GETTERS
    public String getNom() {
        return this.nom;
    }

    //SETTERS
//    public Pays setNom(String nom) {
//        setNom(nom);
//        return this;
//    }
    public void setNom(String nom){
        this.nom = nom;
    }


}
