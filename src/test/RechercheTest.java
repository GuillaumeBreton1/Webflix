package test;

import backend.hibernate.tableMapping.Film;
import backend.hibernate.tableMapping.Pays;
import façade.Facade;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


public class RechercheTest {
    private static String TITRE_FILM1 = "Titanic";
    private static String TITRE_FILM2 = "Das Boot";
    private static int DATE_DEBUT = 1997;
    private static int DATE_FIN = 1999;
    private static String PAYS1 = "Japan";
    private static String PAYS2 = "Canada";
    private static String LANGUE1 = "Japanese";
    private static String LANGUE2 = "French";
    private static String GENRE1 = "Horror";
    private static String GENRE2 = "Action";
    private static String REALISATEUR1 = "Martin Scorsese";
    private static String REALISATEUR2 = "Jean-Pierre Jeunet";
    private static String ACTEUR1 = "Tom Cruise";
    private static String ACTEUR2 = "Leonardo DiCaprio";

    List<Object> params = new ArrayList<Object>();

    public void initParams(){
        this.params = new ArrayList<Object>();
        this.params.add(0,true);
        this.params.add(1,new ArrayList<String>());
        this.params.add(2,1900);
        this.params.add(3,2020);
        this.params.add(4,new ArrayList<String>());
        this.params.add(5,new ArrayList<String>());
        this.params.add(6,new ArrayList<String>());
        this.params.add(7,new ArrayList<String>());
        this.params.add(8,new ArrayList<String>());
    }


    @Test
    public void testRechercheTitre(){
        initParams();
        List<String> titres = new ArrayList<String>();
        titres.add(TITRE_FILM1);
        titres.add(TITRE_FILM2);
        this.params.remove(1);
        this.params.add(1, titres);

        List<Film> films = Facade.getFilms(params);
        System.out.println(films.size());

        for(Film f : films){
            assertTrue(Facade.getInfoFilms(f.getId()).getTitre().equals(TITRE_FILM1)||
                                Facade.getInfoFilms(f.getId()).getTitre().equals(TITRE_FILM2));
        }
    }

    @Test
    public void testRechercheDate(){
        initParams();
        this.params.remove(2);
        this.params.add(2, DATE_DEBUT);
        this.params.remove(3);
        this.params.add(3, DATE_FIN);

        List<Film> films = Facade.getFilms(this.params);

        for(Film f : films){
            assertTrue(f.getDateSortie() >= DATE_DEBUT ||
                                f.getDateSortie() <= DATE_FIN);
        }
    }


    @Test
    public void testRecherchePays(){
        initParams();
        List<String> pays = new ArrayList<String>();
        pays.add(PAYS1);
        this.params.remove(4);
        this.params.add(4, pays);

        List<Film> films = Facade.getFilms(this.params);

        for(Film f : films){

            assertTrue(Facade.getInfoFilms(f.getId()).getPays().stream().anyMatch(pays1 -> pays1.getNom().equals(PAYS1)));
        }
    }


    @Test
    public void testRechercheLangue(){
        initParams();
        List<String> langues = new ArrayList<String>();
        langues.add(LANGUE1);
        langues.add(LANGUE2);
        this.params.remove(5);
        this.params.add(5, langues);
        List<Film> films = Facade.getFilms(params);

        for(Film f : films){
            assertTrue(Facade.getInfoFilms(f.getId()).getLangueOriginale().equals(LANGUE1)||
                    Facade.getInfoFilms(f.getId()).getLangueOriginale().equals(LANGUE2));
        }
    }

    /*
    @Test
    public void testRechercheGenre(){
        initParams();
        List<String> genres = new ArrayList<String>();
        genres.add(GENRE1);
        genres.add(GENRE2);
        this.params.remove(6);
        this.params.add(6, genres);

        List<Film> films = Facade.getFilms(params);

        System.out.println(films.size());

        for(Film f : films){
            System.out.println(Facade.getInfoFilms(f.getId()).getGenres().toArray().toString());

            assertTrue(Facade.getInfoFilms(f.getId()).getGenres().equals(GENRE1)||
                    Facade.getInfoFilms(f.getId()).getGenres().equals(GENRE2));
        }
    }*/

    @Test
    public void testRechercheRealisateur(){
        initParams();
        List<String> realisateurs = new ArrayList<String>();
        realisateurs.add(REALISATEUR1);
        realisateurs.add(REALISATEUR2);
        this.params.remove(7);
        this.params.add(7, realisateurs);

        List<Film> films = Facade.getFilms(this.params);

        for(Film f : films){
            assertTrue(Facade.getInfoFilms(f.getId()).getRealisateur().getNom().equals(REALISATEUR1)||
                    Facade.getInfoFilms(f.getId()).getRealisateur().getNom().equals(REALISATEUR2));
        }
    }

    @Test
    public void testRechercheActeur(){
        initParams();
        List<String> acteurs = new ArrayList<String>();
        acteurs.add(ACTEUR1);
        this.params.remove(8);
        this.params.add(8, acteurs);

        List<Film> films = Facade.getFilms(this.params);

        for(Film f : films){
            assertTrue(Facade.getInfoFilms(f.getId()).getRoles().stream().anyMatch(role -> role.getActeur().getNom().equals(ACTEUR1)));
        }
    }

    @Test
    public void testRechercheMutltipleAND(){
        initParams();
        List<String> acteurs = new ArrayList<String>();
        List<String> titres = new ArrayList<String>();

        titres.add(TITRE_FILM1);
        this.params.remove(1);
        this.params.add(1, titres);

        acteurs.add(ACTEUR2);
        this.params.remove(8);
        this.params.add(8, acteurs);

        List<Film> film = Facade.getFilms(this.params);
        Film f = film.get(0);
        assertTrue(Facade.getInfoFilms(f.getId()).getRoles().stream().anyMatch(role -> role.getActeur().getNom().equals(ACTEUR2)) &&
                    f.getTitre().equals(TITRE_FILM1));

    }

    @Test
    public void testRechercheMutltipleOU(){
        initParams();
        List<String> acteurs = new ArrayList<String>();
        List<String> titres = new ArrayList<String>();

        titres.add(TITRE_FILM1);
        this.params.remove(1);
        this.params.add(1, titres);

        acteurs.add(ACTEUR2);
        this.params.remove(8);
        this.params.add(8, acteurs);

        this.params.remove(2);
        this.params.add(2, DATE_DEBUT);
        this.params.remove(3);
        this.params.add(3, DATE_FIN);

        List<Film> films = Facade.getFilms(this.params);

        for(Film f : films){
            assertTrue(Facade.getInfoFilms(f.getId()).getRoles().stream().anyMatch(role -> role.getActeur().getNom().equals(ACTEUR2)) ||
                    f.getTitre().equals(TITRE_FILM1) || (f.getDateSortie() >= DATE_DEBUT || f.getDateSortie() <= DATE_FIN));
        }
    }

}
