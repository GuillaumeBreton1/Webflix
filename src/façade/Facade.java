package façade;

import backend.courtier.CourtierFilm;
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
    private static CourtierFilm courtierFilm;

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
        /*
        f.setDateSortie(1997);
        f.setTitre("Titanic");
        films.add(f);*/
        films = (ArrayList<Film>) courtierFilm.getListFilms(params);
        return films; 
    }

    public static Film getInfoFilms(int id){
        return courtierFilm.getFilmDetails(id);
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
        Facade.courtierFilm = new CourtierFilm(currentSession);
    }
    public Integer getUserLoggedId() {
        return userLoggedId;
    }

    public void setUserLoggedId(Integer userLoggedId) {
        this.userLoggedId = userLoggedId;
    }
}
