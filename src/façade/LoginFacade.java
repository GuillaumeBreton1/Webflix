package façade;

import backend.hibernate.tableMapping.Utilisateur;
import org.hibernate.Query;
import org.hibernate.Session;

public class LoginFacade {

    private String courriel;
    private char[] motDePasse;
    private static Session currentSession;
    private Utilisateur userLogged;

    public static boolean login(String courriel, char[] motDePasse){
        boolean loginFonctionnel = true;
        try {
            Query query = currentSession.createSQLQuery(" { call p_connexion(?,?) }");
            query.setString(0, courriel);
            query.setString(1, String.valueOf(motDePasse));
            query.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
            loginFonctionnel= false;
        }
        return loginFonctionnel;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public char[] getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(char[] motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        LoginFacade.currentSession = currentSession;
    }
}
