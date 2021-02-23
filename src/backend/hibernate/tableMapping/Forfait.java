package backend.hibernate.tableMapping;

public class Forfait {

    private Character code;
    private String nom;
    private Integer cout;
    private Integer locationMax;
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
