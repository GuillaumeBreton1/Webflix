package backend.courtier;

import backend.hibernate.tableMapping.Film;
import backend.hibernate.tableMapping.Genre;
import backend.hibernate.tableMapping.Pays;
import backend.hibernate.tableMapping.Role;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourtierFilmv2 {

    public List<Film> getListFilm(List<Object> params, Session session){
        List<Film> films = new ArrayList<>();

        boolean isAnd = (boolean)params.get(0);
        List<String> titles = (List<String>) params.get(1);
        Integer dateSortie1 = (Integer) params.get(2);
        Integer dateSortie2 = (Integer) params.get(3);
        List<String> pays = (List<String>) params.get(4);
        List<String> langue = (List<String>) params.get(5);
        List<String> genre = (List<String>) params.get(6);
        List<String> realisateur = (List<String>) params.get(7);
        List<String> acteur = (List<String>) params.get(8);

        List<Film> listeComplete;
        List<Film> titreFilm;
        List<Film> dateFilm;
        List<Film> paysFilm;
        List<Film> langueFilm;
        List<Film> genreFilm;
        List<Film> realisateurFilm;
        List<Film> acteurFilm;

        if(isAnd){
            listeComplete = getAllFilms(session);
            titreFilm = titles.isEmpty() ? listeComplete : rechercheTitre(titles, session);
            dateFilm = rechercheDateSortie(dateSortie1, dateSortie2, session);
            paysFilm = pays.isEmpty() ? listeComplete : recherchePays(pays, session);
            langueFilm = langue.isEmpty() ? listeComplete : rechercheLangue(langue, session);
            genreFilm = genre.isEmpty() ? listeComplete : rechercheGenre(genre, session);
            realisateurFilm = realisateur.isEmpty() ? listeComplete : rechercheRealisateur(realisateur,session);
            acteurFilm = acteur.isEmpty() ? listeComplete : rechercheActeur(acteur, session);
        } else {
            List<Film> listeVide = new ArrayList<>();
            titreFilm = titles.isEmpty() ? listeVide : rechercheTitre(titles,session);
            dateFilm = dateSortie1.equals(-1) ? listeVide : rechercheDateSortie(dateSortie1, dateSortie2,session);
            paysFilm = pays.isEmpty() ? listeVide : recherchePays(pays,session);
            langueFilm = langue.isEmpty() ? listeVide : rechercheLangue(langue,session);
            genreFilm = genre.isEmpty() ? listeVide : rechercheGenre(genre,session);
            realisateurFilm = realisateur.isEmpty() ? listeVide : rechercheRealisateur(realisateur,session);
            acteurFilm = acteur.isEmpty() ? listeVide : rechercheActeur(acteur,session);
        }
        films = filterLists(isAnd, titreFilm, dateFilm, paysFilm, langueFilm, genreFilm, realisateurFilm, acteurFilm);

        return films;
    }

    private List<Film> rechercheTitre(List<String> titres, Session session){
        Map<Integer, Film> filmsMap = new HashMap<>();
        for(String titre : titres){
            titre = "%" + titre + "%";
            Criteria criteria = getCriteria(session);
            criteria.add(Restrictions.ilike("titre", titre));

            List<Film> liste = (List<Film>) criteria.list();
            for(Film film : liste){
                filmsMap.put(film.getId(), film);
            }
        }
        return new ArrayList<>(filmsMap.values());
    }

    private List<Film> rechercheDateSortie(Integer date1, Integer date2, Session session){
        Criteria criteria = getCriteria(session);
        criteria.add(Restrictions.between("dateSortie", date1, date2));
        return (List<Film>) criteria.list();
    }

    private List<Film> recherchePays(List<String> pays, Session session){
        Map<Integer, Film> filmsMap = new HashMap<>();

        for(String nomPays : pays){
            nomPays = "%" + nomPays + "%";
            Query query = session.createQuery("FROM Pays p JOIN FETCH p.films WHERE UPPER(p.nom) LIKE UPPER(:nom)");
            query.setParameter("nom", nomPays);
            List<Film> liste = new ArrayList<>(((List<Pays>) query.list()).get(0).getFilms());
            for(Film film : liste){
                filmsMap.put(film.getId(), film);
            }
        }
        return new ArrayList<>(filmsMap.values());
    }

    private List<Film> rechercheLangue(List<String> langues, Session session){
        Map<Integer, Film> films = new HashMap<>();

        for(String langue : langues){
            langue = "%" + langue + "%";

            Criteria criteria = getCriteria(session);
            criteria.add(Restrictions.ilike("langueOriginale", langue));

            List<Film> liste = (List<Film>) criteria.list();
            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        return new ArrayList<>(films.values());
    }

    private List<Film> rechercheGenre(List<String> genres, Session session){
        Map<Integer, Film> filmsMap = new HashMap<>();

        for(String nomGenre : genres){
            nomGenre = "%" + nomGenre + "%";
            Query query = session.createQuery("FROM Genre g JOIN FETCH g.films WHERE UPPER(g.nom) LIKE UPPER(:nom)");
            query.setParameter("nom", nomGenre);
            List<Film> liste = new ArrayList<>(((List<Genre>) query.list()).get(0).getFilms());
            for(Film film : liste){
                filmsMap.put(film.getId(), film);
            }
        }
        return new ArrayList<>(filmsMap.values());
    }

    private List<Film> rechercheRealisateur(List<String> realisateurs, Session session){
        Map<Integer, Film> films = new HashMap<>();
        for(String realisateur : realisateurs){
            realisateur = "%" + realisateur + "%";

            Query query = session.createQuery(
                    "FROM Film f " +
                            "WHERE UPPER(f.realisateur.nom) LIKE UPPER(:nom)");
            query.setParameter("nom", realisateur);
            List<Film> liste = (List<Film>) query.list();

            for(Film film : liste){
                films.put(film.getId(), film);
            }
        }
        return new ArrayList<>(films.values());
    }

    private List<Film> rechercheActeur(List<String> acteurs, Session session){
        Map<Integer, Film> films = new HashMap<>();
        for(String acteur : acteurs){
            acteur = "%" + acteur + "%";
            Query query = session.createQuery(
                    "FROM Role r JOIN FETCH r.film " +
                            "WHERE UPPER(r.acteur.nom) LIKE UPPER(:nom)");
            query.setParameter("nom", acteur);
            List<Role> listRole = (List<Role>) query.list();
            for(Role role : listRole){
                Film film = role.getFilm();
                films.put(film.getId(), film);
            }
        }
        return new ArrayList<Film>(films.values());
    }

    private List<Film> getAllFilms(Session session){
        Criteria criteria = getCriteria(session);
        List<Film> list = (List<Film>) criteria.list();
        return list;
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

    private List<Film> filterLists(boolean isAnd, List<Film> list1, List<Film> list2, List<Film> list3,
                                   List<Film> list4, List<Film> list5, List<Film> list6, List<Film> list7){
        Map<Integer, Film> filmsMap1 = list1.stream().collect(Collectors.toMap(Film::getId, film -> film));

        if(!isAnd){ // OR
            List<List<Film>> listOfList = new ArrayList<>();
            listOfList.add(list2);
            listOfList.add(list3);
            listOfList.add(list4);
            listOfList.add(list5);
            listOfList.add(list6);
            listOfList.add(list7);
            for(List<Film> liste : listOfList){
                for(Film film : liste){
                    filmsMap1.put(film.getId(), film);
                }
            }
        }else{ // AND
            List<Integer> idsToRemove = new ArrayList<>();

            Map<Integer, Film> filmsMap2 = list2.stream().collect(Collectors.toMap(Film::getId, film -> film));
            Map<Integer, Film> filmsMap3 = list3.stream().collect(Collectors.toMap(Film::getId, film -> film));
            Map<Integer, Film> filmsMap4 = list4.stream().collect(Collectors.toMap(Film::getId, film -> film));
            Map<Integer, Film> filmsMap5 = list5.stream().collect(Collectors.toMap(Film::getId, film -> film));
            Map<Integer, Film> filmsMap6 = list6.stream().collect(Collectors.toMap(Film::getId, film -> film));
            Map<Integer, Film> filmsMap7 = list7.stream().collect(Collectors.toMap(Film::getId, film -> film));

            for (Map.Entry<Integer, Film> entry : filmsMap1.entrySet()) {
                if(!filmsMap2.containsKey(entry.getKey())){
                    idsToRemove.add(entry.getKey());
                    continue;
                }
                if(!filmsMap3.containsKey(entry.getKey())){
                    idsToRemove.add(entry.getKey());
                    continue;
                }
                if(!filmsMap4.containsKey(entry.getKey())){
                    idsToRemove.add(entry.getKey());
                    continue;
                }
                if(!filmsMap5.containsKey(entry.getKey())){
                    idsToRemove.add(entry.getKey());
                    continue;
                }
                if(!filmsMap6.containsKey(entry.getKey())){
                    idsToRemove.add(entry.getKey());
                    continue;
                }
                if(!filmsMap7.containsKey(entry.getKey())){
                    idsToRemove.add(entry.getKey());
                    continue;
                }
            }
            for(Integer id : idsToRemove){
                filmsMap1.remove(id);
            }
        }
        return new ArrayList<>(filmsMap1.values());
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
}
