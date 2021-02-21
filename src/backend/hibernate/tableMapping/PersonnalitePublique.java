package backend.hibernate.tableMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PersonnalitePublique")
public class PersonnalitePublique {

    @Id
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @Column(name = "provenance")
    private String provenance;

    @Column(name = "lienPhoto")
    private String lienPhoto;

    @Column(name = "biographie")
    private String biographie;

    @ManyToOne
    @JoinColumn(name = "typePersonne")
    private TypePersonne typePersonne;

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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getLienPhoto() {
        return lienPhoto;
    }

    public void setLienPhoto(String lienPhoto) {
        this.lienPhoto = lienPhoto;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public TypePersonne getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(TypePersonne typePersonne) {
        this.typePersonne = typePersonne;
    }
}
