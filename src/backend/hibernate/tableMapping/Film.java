package backend.hibernate.tableMapping;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Film")
public class Film {

    @Id
    private Integer id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "dateSortie")
    private Integer dateSortie;

    @Column(name = "langueOriginale")
    private String langueOriginale;

    @Column(name = "duree")
    private Integer duree;

    @Column(name = "lienAffiche")
    private String lienAffiche;

    @Column(name = "resumeScenario")
    private String resumeScenario;

    @ManyToOne
    @JoinColumn(name = "idRealisateur")
    private PersonnalitePublique realisateur;

    @ManyToMany
    @JoinTable(
            name = "FilmGenre",
            joinColumns = @JoinColumn(name = "idFilm"),
            inverseJoinColumns = @JoinColumn(name = "idGenre"))
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "FilmPays",
            joinColumns = @JoinColumn(name = "idFilm"),
            inverseJoinColumns = @JoinColumn(name = "idPays"))
    private Set<Pays> pays;

    @ManyToMany
    @JoinTable(
            name = "FilmScenariste",
            joinColumns = @JoinColumn(name = "idFilm"),
            inverseJoinColumns = @JoinColumn(name = "idScenariste"))
    private Set<Scenariste> scenaristes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Integer dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getLangueOriginale() {
        return langueOriginale;
    }

    public void setLangueOriginale(String langueOriginale) {
        this.langueOriginale = langueOriginale;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getLienAffiche() {
        return lienAffiche;
    }

    public void setLienAffiche(String lienAffiche) {
        this.lienAffiche = lienAffiche;
    }

    public String getResumeScenario() {
        return resumeScenario;
    }

    public void setResumeScenario(String resumeScenario) {
        this.resumeScenario = resumeScenario;
    }

    public PersonnalitePublique getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(PersonnalitePublique realisateur) {
        this.realisateur = realisateur;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Pays> getPays() {
        return pays;
    }

    public void setPays(Set<Pays> pays) {
        this.pays = pays;
    }

    public Set<Scenariste> getScenaristes() {
        return scenaristes;
    }

    public void setScenaristes(Set<Scenariste> scenaristes) {
        this.scenaristes = scenaristes;
    }
}
