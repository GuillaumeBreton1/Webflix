package backend.hibernate.tableMapping;

import javax.persistence.*;

@Entity
@Table(name = "TypeCarteCredit")
public class TypeCarteCredit {

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "nom")
    private String nom;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
