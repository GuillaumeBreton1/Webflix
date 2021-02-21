package backend.hibernate.tableMapping;

import javax.persistence.*;

@Entity
@Table(name = "BandeAnnonce")
public class BandeAnnonce {

    @Id
    private Integer id;

    @Column(name = "lien")
    private String lien;

    @ManyToOne
    @JoinColumn(name = "idFilm")
    private Film film;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}