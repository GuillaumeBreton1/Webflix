package façade;

import backend.courtier.CourtierFilm;
import backend.courtier.CourtierFilmv2;
import backend.courtier.CourtierLocation;
import backend.hibernate.HibernateUtil;
import backend.hibernate.tableMapping.Film;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Facade {

    private static Session currentSession;
    private static Integer userLoggedId;
    private String courriel;
    private char[] motDePasse;
    private static CourtierLocation courtierLocation = new CourtierLocation();
    private static CourtierFilm courtierFilm = new CourtierFilm();
    private static CourtierFilmv2 courtierFilmv2 = new CourtierFilmv2();

    //Session sessionMain = HibernateUtil.getSessionFactory().openSession();

    public static boolean login(String courriel, char[] motDePasse) {
        boolean loginFonctionnel = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createSQLQuery(" { call p_connexion(?,?) }");
            query.setString(0, courriel);
            query.setString(1, String.valueOf(motDePasse));
            query.executeUpdate();

            Query selectQuery = session.createQuery("SELECT U.id FROM Utilisateur U WHERE U.courriel = :userCourriel");
            selectQuery.setString("userCourriel", courriel);
            List resultatsUtilisateur = selectQuery.list();
            userLoggedId = (Integer) resultatsUtilisateur.get(0);

        } catch (Exception e) {
            e.printStackTrace();
            loginFonctionnel = false;
        } finally {
            transaction.commit();
            session.close();
        }
        return loginFonctionnel;
    }

    public static boolean locationExemplaire(Integer filmId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        courtierLocation = new CourtierLocation();
        boolean locationValide = true;
        try {
            locationValide = courtierLocation.locationExemplaire(userLoggedId, filmId, session);
        }catch(Exception e){
            transaction.rollback();
            locationValide = false;
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }

        return locationValide;
    }

    // Retourne la liste de films demandés lors de la recherche, prend en paramètre la liste de recherche
    public static ArrayList<Film> getFilms(List<Object> params) {
        ArrayList<Film> films = new ArrayList<Film>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            films = (ArrayList<Film>) courtierFilmv2.getListFilm(params, session);
        } catch (Exception e) {

        } finally {
            transaction.commit();
            session.close();
        }
        return films;
    }

    public static Film getInfoFilms(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Film f = null;
        try {
            f = courtierFilm.getFilmDetails(id, session);
        } catch (Exception e) {

        } finally {
            transaction.commit();
            session.close();
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
