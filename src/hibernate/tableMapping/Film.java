package hibernate.tableMapping;

import java.sql.Date;
import java.util.ArrayList;

public class Film {

    private String titre; 
    private Integer dateSortie;
    private String langueOriginale; 
    private int duree; 
    private String resumeScenario; 
    private String affiche; 
    private ArrayList<Genre> genres;
    private ArrayList<BandeAnnonce> bandeAnnonce;
    private PersonnalitePublique realisateur; 
    private ArrayList<PersonnalitePublique> scenaristes;
    private ArrayList<Role> roles;


    public Film(String titre, Integer dateSortie, String langueOriginale, int duree, String resumeScenario,
                String affiche, ArrayList<Genre> genres, ArrayList<BandeAnnonce> bandeAnnonce, PersonnalitePublique realisateur,
                ArrayList<PersonnalitePublique> scenaristes, ArrayList<Role> roles) {

        this.titre = titre;
        this.dateSortie = dateSortie;
        this.langueOriginale = langueOriginale;
        this.duree = duree;
        this.resumeScenario = resumeScenario;
        this.affiche = affiche;
        this.genres = genres;
        this.bandeAnnonce = bandeAnnonce;
        this.realisateur = realisateur;
        this.scenaristes = scenaristes;
        this.roles = roles;

    }

    //GETTERS 
    public String getTitre() {
        return this.titre;
    }


    public Integer getDateSortie() {
        return this.dateSortie;
    }


    public String getLangueOriginale() {
        return this.langueOriginale;
    }


    public int getDuree() {
        return this.duree;
    }


    public String getResumeScenario() {
        return this.resumeScenario;
    }


    public String getAffiche() {
        return this.affiche;
    }


    public ArrayList<Genre> getGenre() {
        return this.genres;
    }


    public ArrayList<BandeAnnonce> getBandeAnnonce() {
        return this.bandeAnnonce;
    }


    public PersonnalitePublique getRealisateur() {
        return this.realisateur;
    }


    public ArrayList<PersonnalitePublique> getScenaristes() {
        return this.scenaristes;
    }


    public ArrayList<Role> getRoles() {
        return this.roles;
    }

    //SETTERS
    public Film setTitre(String titre) {
        setTitre(titre);
        return this;
    }

    public Film setDateSortie(Date dateSortie) {
        setDateSortie(dateSortie);
        return this;
    }

    public Film setLangueOriginale(String langueOriginale) {
        setLangueOriginale(langueOriginale);
        return this;
    }

    public Film setDuree(int duree) {
        setDuree(duree);
        return this;
    }

    public Film setResumeScenario(String resumeScenario) {
        setResumeScenario(resumeScenario);
        return this;
    }

    public Film setAffiche(String affiche) {
        setAffiche(affiche);
        return this;
    }

    public Film setGenre(Genre[] genre) {
        setGenre(genre);
        return this;
    }

    public Film setBandeAnnonce(BandeAnnonce[] bandeAnnonce) {
        setBandeAnnonce(bandeAnnonce);
        return this;
    }

    public Film setRealisateur(PersonnalitePublique realisateur) {
        setRealisateur(realisateur);
        return this;
    }

    public Film setScenaristes(PersonnalitePublique[] scenaristes) {
        setScenaristes(scenaristes);
        return this;
    }

    public Film setRoles(Role[] roles) {
        setRoles(roles);
        return this;
    }
}
