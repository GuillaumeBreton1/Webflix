package hibernate.tableMapping;

public class Forfait {

    private String nom; 
    private int cout; 
    private int locationMax; 
    private char code;
    private int dureeMax;

    private static Forfait debutant = new Forfait("Débutant", 5, 1, 'D', 10);
    private static Forfait intermediaire = new Forfait("Intermédiaire", 10, 5, 'I', 30);
    private static Forfait avance = new Forfait("Avancé", 15, 10, 'A', 0);

    public static Forfait getForfait(char code){
        if(code == debutant.getCode()){
            return debutant;
        }
        else if(code == intermediaire.getCode()){
            return intermediaire;
        }
        else{
            return avance;
        }
    }

    public static Forfait getDebutant(){
        return debutant;
    }

    public static Forfait getIntermediaire(){
        return intermediaire;
    }

    public static Forfait getAvance(){
        return avance;
    }

    private Forfait(String nom, int cout, int locationMax, char code, int dureeMax) {

        this.nom = nom;
        this.cout = cout;
        this.locationMax = locationMax;
        this.code = code;
        this.dureeMax = dureeMax;

    }

    //GETTERS
    public String getNom() {
        return this.nom;
    }


    public int getCout() {
        return this.cout;
    }


    public int getLocationMax() {
        return this.locationMax;
    }


    public char getCode() {
        return this.code;
    }


    public int getDureeMax() {
        return this.dureeMax;
    }
}
