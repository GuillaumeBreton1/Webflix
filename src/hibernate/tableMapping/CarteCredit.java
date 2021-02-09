package hibernate.tableMapping;

import java.sql.Date;

public class CarteCredit {

    public static final int VISA = 1;
    public static final int MASTERCARD = 2;
    public static final int AMEX = 3;

    private int type; 
    private long numero; 
    private Date dateExpiration; 
    private int cvv; 
    
    public CarteCredit(){}

    public CarteCredit(int type, long numero, Date dateExpiration, int cvv) {
        this.type = type;
        this.numero = numero;
        this.dateExpiration = dateExpiration;
        this.cvv = cvv;
    }

    //GETTERS
    public int getType() {
        return this.type;
    }


    public long getNumero() {
        return this.numero;
    }


    public Date getDateExpiration() {
        return this.dateExpiration;
    }


    public int getCvv() {
        return this.cvv;
    }

    //SETTERS
    public CarteCredit setType(int type) {
        setType(type);
        return this;
    }

    public CarteCredit setNumero(long numero) {
        setNumero(numero);
        return this;
    }

    public CarteCredit setDateExpiration(Date dateExpiration) {
        setDateExpiration(dateExpiration);
        return this;
    }

    public CarteCredit setCvv(int cvv) {
        setCvv(cvv);
        return this;
    }

    public static int checkType(String type){
        if(type.equals("Visa")){
            return VISA;
        }
        else if(type.equals("MasterCard")){
            return MASTERCARD;
        }
        else{
            return AMEX;
        }
    }

}
