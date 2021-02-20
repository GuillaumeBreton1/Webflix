package hibernate.tableMapping;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Exemplaire")
public class Exemplaire {

    @Id
    private Integer id;

    @Column(name = "dateAchat")
    private Date dateAchat;

    @ManyToOne
    @JoinColumn(name = "idFilm")
    private Film film;

    @Column(name = "disponibilite")
    private Integer disponibilite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Integer disponibilite) {
        this.disponibilite = disponibilite;
    }
}