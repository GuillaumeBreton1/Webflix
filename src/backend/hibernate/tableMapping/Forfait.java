package backend.hibernate.tableMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Forfait")
public class Forfait {

    @Column(name = "code")
    private Character code;

    @Column(name = "nom")
    private String nom;

    @Column(name = "cout")
    private Integer cout;

    @Column(name = "locationMax")
    private Integer locationMax;

    @Column(name = "dureeMax")
    private Integer dureeMax;

    public Character getCode() {
        return code;
    }

    public void setCode(Character code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCout() {
        return cout;
    }

    public void setCout(Integer cout) {
        this.cout = cout;
    }

    public Integer getLocationMax() {
        return locationMax;
    }

    public void setLocationMax(Integer locationMax) {
        this.locationMax = locationMax;
    }

    public Integer getDureeMax() {
        return dureeMax;
    }

    public void setDureeMax(Integer dureeMax) {
        this.dureeMax = dureeMax;
    }
}
