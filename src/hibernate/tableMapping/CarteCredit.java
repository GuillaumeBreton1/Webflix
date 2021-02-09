package hibernate.tableMapping;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CarteCredit")
public class CarteCredit {

    @Column(name = "numero")
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "typeCarte")
    private TypeCarteCredit typeCarteCredit;

    @Column(name = "dateExpiration")
    private Date dateExpiration;

    @Column(name = "cvv")
    private Integer cvv;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TypeCarteCredit getTypeCarteCredit() {
        return typeCarteCredit;
    }

    public void setTypeCarteCredit(TypeCarteCredit typeCarteCredit) {
        this.typeCarteCredit = typeCarteCredit;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
}
