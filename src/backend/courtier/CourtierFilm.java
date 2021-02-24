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

    private Session session;

    public CourtierFilm(Session session){
        this.session = session;
    }

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
    public List<Film> getListFilms(List<Object> params){
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

        Transaction transaction = null;
        try {
            List<Film> titleSearch = titles.isEmpty()?getAllFilms():listFromTitles(titles);
            List<Film> dateSearch = listFromReleaseYear(dateSortie1, dateSortie2);
            List<Film> countrySearch = pays.isEmpty()?getAllFilms():listFromCountries(pays);
            List<Film> languageSearch = langue.isEmpty()?getAllFilms():listFromLanguages(langue);
            List<Film> genreSearch = genre.isEmpty()?getAllFilms():listFromGenres(genre);
            List<Film> realisateurSearch = realisateur.isEmpty()?getAllFilms():listFromRealisateur(realisateur);
            List<Film> acteurSearch = acteur.isEmpty()?getAllFilms():listFromActeurs(acteur);

            films = filterList(condition, titleSearch, dateSearch, countrySearch,
                    languageSearch, genreSearch, realisateurSearch, acteurSearch);

        } catch (HibernateException e) {
            //transaction.rollback();
            e.printStackTrace();
        }

        return films;
    }

    public Film getFilmDetails(Integer idFilm){
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Query query = session.createQuery(
                "FROM FILM f " +
                        "WHERE f.id = :id");
        query.setInteger("id", idFilm);
        return (Film) query.list().get(0);
    }

    private List<Film> listFromTitles(List<String> titles){
        Map<Integer, Film> films = new HashMap<>();

        for(String title : titles){
            title = "%" + title + "%";

            Criteria criteria = getCriteria();
            criteria.add(Restrictions.like("titre", title));

            List<Film> liste = (List<Film>) criteria.list();
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        return new ArrayList<>(films.values());
    }

    private List<Film> listFromReleaseYear(Integer date1, Integer date2){

        Criteria criteria = getCriteria();
        criteria.add(Restrictions.between("dateSortie", date1, date2));

        return (List<Film>) criteria.list();
    }

    private List<Film> listFromCountries(List<String> countries){
        Map<Integer, Film> films = new HashMap<>();

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
        return new ArrayList<Film>(films.values());
    }

    private List<Film> listFromGenres(List<String> genres){
        Map<Integer, Film> films = new HashMap<>();

        for(String genre : genres){
            genre = "%" + genre + "%";
            Query query = session.createQuery(
                    "FROM Pays p " +
                            "WHERE UPPER(p.nom) LIKE UPPER(:nom)");
            query.setParameter("nom", genre);
            List<Film> liste = new ArrayList(((Genre) query.uniqueResult()).getFilms());
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        return new ArrayList<Film>(films.values());
    }

    private List<Film> listFromLanguages(List<String> languages){
        Map<Integer, Film> films = new HashMap<>();

        for(String language : languages){
            language = "%" + language + "%";

            Criteria criteria = getCriteria();
            criteria.add(Restrictions.like("langueOriginale", language));

            List<Film> liste = (List<Film>) criteria.list();
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        return new ArrayList<>(films.values());
    }

    private List<Film> listFromRealisateur(List<String> realisateurs){
        Map<Integer, Film> films = new HashMap<>();

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
        return new ArrayList<>(films.values());
    }

    private List<Film> listFromActeurs(List<String> acteurs){
        Map<Integer, Film> films = new HashMap<>();

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

    private Criteria getCriteria(){
        Criteria criteria = session.createCriteria(Film.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id")
                .add(Projections.property("titre"), "titre")
                .add(Projections.property("dateSortie"), "dateSortie"))
                .setResultTransformer(Transformers.aliasToBean(Film.class));
        return criteria;
    }

    private List<Film> getAllFilms(){
        Criteria criteria = getCriteria();
        return (List<Film>) criteria.list();
    }

}
