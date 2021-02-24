package façade;

import backend.courtier.CourtierFilm;
import backend.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import backend.hibernate.tableMapping.Film;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Facade {

    private static Session currentSession;
    private static Integer userLoggedId;
    private String courriel;
    private char[] motDePasse;
    private static CourtierFilm courtierFilm = new CourtierFilm();
    //Session sessionMain = HibernateUtil.getSessionFactory().openSession();

    public static boolean login(String courriel, char[] motDePasse){
        boolean loginFonctionnel = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createSQLQuery(" { call p_connexion(?,?) }");
            query.setString(0, courriel);
            query.setString(1, String.valueOf(motDePasse));
            query.executeUpdate();

            Query selectQuery = session.createQuery("FROM Utilisateur U WHERE U.courriel = :userCourriel");
            selectQuery.setString("userCourriel", courriel);
            List resultatsUtilisateur = selectQuery.list();
            userLoggedId = resultatsUtilisateur.indexOf(0);

        }catch(Exception e){
            e.printStackTrace();
            loginFonctionnel= false;
        }finally {
            transaction.commit();
        }
        return loginFonctionnel;
    }

    // Retourne la liste de films demandés lors de la recherche, prend en paramètre la liste de recherche 
    public static ArrayList<Film> getFilms(List<Object> params){
        ArrayList<Film> films = new ArrayList<Film>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            films = (ArrayList<Film>) courtierFilm.getListFilms(params, session);
        }catch(Exception e){

        }finally {
            transaction.commit();
        }
        return films;
    }

    public static Film getInfoFilms(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Film f = null;
        try{
            f = courtierFilm.getFilmDetails(id, session);
        }catch(Exception e){

        }finally {
            transaction.commit();
            return f;
        }
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
        Facade.courtierFilm = new CourtierFilm();
    }
    public Integer getUserLoggedId() {
        return userLoggedId;
    }

    public void setUserLoggedId(Integer userLoggedId) {
        this.userLoggedId = userLoggedId;
    }
}
