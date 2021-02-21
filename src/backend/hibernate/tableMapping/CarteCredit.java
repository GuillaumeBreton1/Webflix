package backend.hibernate.tableMapping;

import java.sql.Date;

public class CarteCredit {

    private Long numero;

    private TypeCarteCredit typeCarteCredit;

    private Date dateExpiration;

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
