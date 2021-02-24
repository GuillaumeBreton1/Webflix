package backend.courtier;

import backend.hibernate.tableMapping.Film;
import backend.hibernate.tableMapping.Genre;
import backend.hibernate.tableMapping.Pays;
import backend.hibernate.tableMapping.Role;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import java.sql.Connection;
import java.util.*;

public class CourtierFilm {

    /*
    * Paramètres Index
    * 0 : OR ou AND
    * 1 : Titre             LISTE
    * 2 : dateSortie 1
    * 3 : dateSortie 2
    * 4 : Pays              LISTE
    * 5 : Langue            LISTE
    * 6 : Genre             LISTE
    * 7 : Réalisateur       LISTE
    * 8 : Acteur            LISTE
    * */
    public List<Film> getListFilms(List<Object> params, Session session){
        List<Film> films = new ArrayList<>();

        boolean condition = (boolean)params.get(0);
        List<String> titles = (List<String>) params.get(1);
        Integer dateSortie1 = (Integer) params.get(2);
        Integer dateSortie2 = (Integer) params.get(3);
        List<String> pays = (List<String>) params.get(4);
        List<String> langue = (List<String>) params.get(5);
        List<String> genre = (List<String>) params.get(6);
        List<String> realisateur = (List<String>) params.get(7);
        List<String> acteur = (List<String>) params.get(8);

        //Transaction transaction = null;
        try {

            //transaction = session.beginTransaction();

            List<Film> titleSearch;
            List<Film> dateSearch;
            List<Film> countrySearch;
            List<Film> languageSearch;
            List<Film> genreSearch;
            List<Film> realisateurSearch;
            List<Film> acteurSearch;
            if(condition) {
                titleSearch = titles.isEmpty() ? getAllFilms(session) : listFromTitles(titles,session);
                dateSearch = listFromReleaseYear(dateSortie1, dateSortie2, session);
                countrySearch = pays.isEmpty() ? getAllFilms(session) : listFromCountries(pays, session);
                languageSearch = langue.isEmpty() ? getAllFilms(session) : listFromLanguages(langue, session);
                genreSearch = genre.isEmpty() ? getAllFilms(session) : listFromGenres(genre, session);
                realisateurSearch = realisateur.isEmpty() ? getAllFilms(session) : listFromRealisateur(realisateur, session);
                acteurSearch = acteur.isEmpty() ? getAllFilms(session) : listFromActeurs(acteur, session);
            }
            else{
                titleSearch = titles.isEmpty() ? new ArrayList<Film>() : listFromTitles(titles,session);
                dateSearch = dateSortie1.equals(-1) ? new ArrayList<Film>() : listFromReleaseYear(dateSortie1, dateSortie2,session);
                countrySearch = pays.isEmpty() ? new ArrayList<Film>() : listFromCountries(pays, session);
                languageSearch = langue.isEmpty() ? new ArrayList<Film>() : listFromLanguages(langue,session);
                genreSearch = genre.isEmpty() ? new ArrayList<Film>() : listFromGenres(genre, session);
                realisateurSearch = realisateur.isEmpty() ? new ArrayList<Film>() : listFromRealisateur(realisateur, session);
                acteurSearch = acteur.isEmpty() ? new ArrayList<Film>() : listFromActeurs(acteur, session);
            }
            films = filterList(condition, titleSearch, dateSearch, countrySearch,
                    languageSearch, genreSearch, realisateurSearch, acteurSearch);
            //transaction.commit();

        } catch (HibernateException e) {
            //transaction.rollback();
            e.printStackTrace();
        }

        return films;
    }

    public Film getFilmDetails(Integer idFilm, Session session){

        //session.beginTransaction();
        Query query = session.createQuery(
                "FROM Film f " +
                        "WHERE f.id = :id");
        query.setInteger("id", idFilm);
        Film film = (Film) query.list().get(0);
        //session.getTransaction().commit();
        return film;
    }

    private List<Film> listFromTitles(List<String> titles, Session session){
        Map<Integer, Film> films = new HashMap<>();
        //session.beginTransaction();
        for(String title : titles){
            title = "%" + title + "%";

            Criteria criteria = getCriteria(session);
            criteria.add(Restrictions.like("titre", title));

            List<Film> liste = (List<Film>) criteria.list();
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        //session.getTransaction().commit();
        return new ArrayList<>(films.values());
    }

    private List<Film> listFromReleaseYear(Integer date1, Integer date2, Session session){
        //session.beginTransaction();
        Criteria criteria = getCriteria(session);
        criteria.add(Restrictions.between("dateSortie", date1, date2));

        List<Film> list = (List<Film>) criteria.list();
        //session.getTransaction().commit();
        return list;
    }

    private List<Film> listFromCountries(List<String> countries, Session session){
        Map<Integer, Film> films = new HashMap<>();
        //session.beginTransaction();
        for(String country : countries){
            country = "%" + country + "%";
            Query query = session.createQuery(
                    "FROM Pays p " +
                            "WHERE UPPER(p.nom) LIKE UPPER(:nom)");
            query.setParameter("nom", country);
            List<Film> liste = new ArrayList(((Pays) query.uniqueResult()).getFilms());
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        //session.getTransaction().commit();
        return new ArrayList<Film>(films.values());
    }

    private List<Film> listFromGenres(List<String> genres, Session session){
        Map<Integer, Film> films = new HashMap<>();
        //session.beginTransaction();

        for(String genre : genres){
            genre = "%" + genre + "%";
            Query query = session.createQuery(
                    "FROM Genre g " +
                            "WHERE UPPER(g.nom) LIKE UPPER(:nom)");
            query.setParameter("nom", genre);
            List<Film> liste = new ArrayList(((Genre) query.uniqueResult()).getFilms());
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        //session.getTransaction().commit();
        return new ArrayList<Film>(films.values());
    }

    private List<Film> listFromLanguages(List<String> languages, Session session){
        Map<Integer, Film> films = new HashMap<>();

        //session.beginTransaction();
        for(String language : languages){
            language = "%" + language + "%";

            Criteria criteria = getCriteria(session);
            criteria.add(Restrictions.like("langueOriginale", language));

            List<Film> liste = (List<Film>) criteria.list();
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        //session.getTransaction().commit();
        return new ArrayList<>(films.values());
    }

    private List<Film> listFromRealisateur(List<String> realisateurs, Session session){
        Map<Integer, Film> films = new HashMap<>();
        //session.beginTransaction();
        for(String realisateur : realisateurs){
            realisateur = "%" + realisateur + "%";

            Query query = session.createQuery(
                    "FROM Film f " +
                            "WHERE f.realisateur.nom LIKE UPPER(:nom)");
            query.setParameter("nom", realisateur);
            List<Film> liste = (List<Film>) query.list();

            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        //session.getTransaction().commit();
        return new ArrayList<>(films.values());
    }

    private List<Film> listFromActeurs(List<String> acteurs, Session session){
        Map<Integer, Film> films = new HashMap<>();
        //session.beginTransaction();
        for(String acteur : acteurs){
            acteur = "%" + acteur + "%";
            Query query = session.createQuery(
                    "FROM Role r " +
                            "WHERE UPPER(r.acteur.nom) LIKE (:nom)");
            query.setParameter("nom", acteur);
            List<Role> listRole = (List<Role>) query.list();
            for(Role role : listRole){
                Film film = role.getFilm();
                films.put(film.getId(), film);
            }
        }
        //session.getTransaction().commit();
        return new ArrayList<Film>(films.values());
    }

    private List<Film> filterList(boolean condition, List<Film> list1, List<Film> list2, List<Film> list3,
                                  List<Film> list4, List<Film> list5, List<Film> list6, List<Film> list7){
        Map<Integer, Film> filmsMap = new HashMap<>();
        for(Film film : list1){
            filmsMap.put(film.getId(), film);
        }
        if(!condition /* OR */){
            for(Film film : list2){
                filmsMap.put(film.getId(), film);
            }
            for(Film film : list3){
                filmsMap.put(film.getId(), film);
            }
            for(Film film : list4){
                filmsMap.put(film.getId(), film);
            }
            for(Film film : list5){
                filmsMap.put(film.getId(), film);
            }
            for(Film film : list6){
                filmsMap.put(film.getId(), film);
            }
            for(Film film : list7){
                filmsMap.put(film.getId(), film);
            }
        } else /* AND */{
            for (Map.Entry<Integer, Film> entry : filmsMap.entrySet()) {
                if(!list2.contains(entry.getValue())){
                    filmsMap.remove(entry.getValue());
                    continue;
                }
                if(!list3.contains(entry.getValue())){
                    filmsMap.remove(entry.getValue());
                    continue;
                }
                if(!list4.contains(entry.getValue())){
                    filmsMap.remove(entry.getValue());
                    continue;
                }
                if(!list5.contains(entry.getValue())){
                    filmsMap.remove(entry.getValue());
                    continue;
                }
                if(!list6.contains(entry.getValue())){
                    filmsMap.remove(entry.getValue());
                    continue;
                }
                if(!list7.contains(entry.getValue())){
                    filmsMap.remove(entry.getValue());
                    continue;
                }
            }
        }
        return new ArrayList<Film>(filmsMap.values());
    }

    private Criteria getCriteria(Session session){
        Criteria criteria = session.createCriteria(Film.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id")
                .add(Projections.property("titre"), "titre")
                .add(Projections.property("dateSortie"), "dateSortie"))
                .setResultTransformer(Transformers.aliasToBean(Film.class));
        return criteria;
    }

    private List<Film> getAllFilms(Session session){
        //session.beginTransaction();
        Criteria criteria = getCriteria(session);
        List<Film> list = (List<Film>) criteria.list();
        //session.getTransaction().commit();
        return list;
    }

}
