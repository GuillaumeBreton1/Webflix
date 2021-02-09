package hibernate.tableMapping;

import javax.persistence.*;

@Entity
@Table(name = "TypePersonne")
public class TypePersonne {

    @Column(name = "code")
    private Integer code;

    @Column(name = "nom")
    private String nom;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
