package façade;

import org.hibernate.Query;
import org.hibernate.Session;

import backend.hibernate.tableMapping.Film;

import java.util.ArrayList;
import java.util.List;

public class Facade {

    private static Session currentSession;
    private static Integer userLoggedId;
    private String courriel;
    private char[] motDePasse;

    public static boolean login(String courriel, char[] motDePasse){
        boolean loginFonctionnel = true;
        try {
            Query query = currentSession.createSQLQuery(" { call p_connexion(?,?) }");
            query.setString(0, courriel);
            query.setString(1, String.valueOf(motDePasse));
            query.executeUpdate();

            Query selectQuery = currentSession.createQuery("FROM Utilisateur U WHERE U.courriel = :userCourriel");
            selectQuery.setString("userCourriel", courriel);
            List resultatsUtilisateur = selectQuery.list();
            userLoggedId = resultatsUtilisateur.indexOf(0);

        }catch(Exception e){
            e.printStackTrace();
            loginFonctionnel= false;
        }
        return loginFonctionnel;
    }

    // Retourne la liste de films demandés lors de la recherche, prend en paramètre la liste de recherche 
    public static ArrayList<Film> getFilms(List<Object> params){
        ArrayList<Film> films = new ArrayList<Film>(); 

        Film f = new Film(); 
        f.setTitre("Titanic"); 
        f.setDateSortie(1997);
        films.add(f); 

        return films; 
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
        Facade.currentSession = currentSession;
    }
    public Integer getUserLoggedId() {
        return userLoggedId;
    }

    public void setUserLoggedId(Integer userLoggedId) {
        this.userLoggedId = userLoggedId;
    }
}
