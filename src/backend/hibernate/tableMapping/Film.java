package backend.hibernate.tableMapping;

import java.util.Set;

public class Film {

    private Integer id;
    private String titre;
    private Integer dateSortie;
    private String langueOriginale;
    private Integer duree;
    private String lienAffiche;
    private String resumeScenario;
    private PersonnalitePublique realisateur;
    private Set<Genre> genres;
    private Set<Pays> pays;
    private Set<Scenariste> scenaristes;
    private Set<Role> roles;
    private Set<BandeAnnonce> bandeAnnonces;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<BandeAnnonce> getBandeAnnonces() {
        return bandeAnnonces;
    }

    public void setBandeAnnonces(Set<BandeAnnonce> bandeAnnonces) {
        this.bandeAnnonces = bandeAnnonces;
    }

    @Override
    public String toString(){
        return titre + " (" + dateSortie + ")";
    }
}
