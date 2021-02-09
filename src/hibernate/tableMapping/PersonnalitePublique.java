package hibernate.tableMapping;

import java.sql.Date;

public class PersonnalitePublique {

    private Integer id;
    private String nom; 
    private Date dateNaissance;
    private Pays lieuNaissance;
    private String lienPhoto;
    private String biographie;
    public enum Types {Réalisateur, Acteur}
    private Types type;

    public PersonnalitePublique(Types type) {
        this.type = type;
    }

    public PersonnalitePublique(Integer id, String nom, Types type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    public PersonnalitePublique(Integer id, String nom, Date dateNaissance, Pays lieuNaissance, String lienPhoto, String biographie, Types type) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.lienPhoto = lienPhoto;
        this.biographie = biographie;
        this.type = type;
    }

    //GETTERS
    public Integer getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }


    public Date getDateNaissance() {
        return this.dateNaissance;
    }


    public Pays getLieuNaissance() {
        return this.lieuNaissance;
    }


    public String getLienPhoto() {
        return this.lienPhoto;
    }


    public String getBiographie() {
        return this.biographie;
    }


    public Types getType() {
        return this.type;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public PersonnalitePublique setDateNaissance(Date dateNaissance) {
        setDateNaissance(dateNaissance);
        return this;
    }

    public PersonnalitePublique setLieuNaissance(Pays lieuNaissance) {
        setLieuNaissance(lieuNaissance);
        return this;
    }

    public PersonnalitePublique setLienPhoto(String lienPhoto) {
        setLienPhoto(lienPhoto);
        return this;
    }

    public PersonnalitePublique setBiographie(String biographie) {
        setBiographie(biographie);
        return this;
    }

    public void setType(Types type) {
        this.type = type;
    }

}
