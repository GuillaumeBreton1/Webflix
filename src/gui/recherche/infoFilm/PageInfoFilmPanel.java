package gui.recherche.infoFilm;

import backend.hibernate.tableMapping.Film;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PageInfoFilmPanel extends JPanel {

    private TitreInfoFilmPanel titreInfoFilmPanel;
    private InfoFilmPanel infoFilmPanel;

    public PageInfoFilmPanel() {
        this.titreInfoFilmPanel = new TitreInfoFilmPanel();
        this.infoFilmPanel = new InfoFilmPanel();
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(new EmptyBorder(0, 40, 40, 40));
        this.add(this.titreInfoFilmPanel, BorderLayout.NORTH);
        this.add(this.infoFilmPanel);
    }

    public void setMovie(Film film) {
        this.titreInfoFilmPanel.setTitreFilm(film);
        this.infoFilmPanel.setInfoDuFilm(film);
    }

    public InfoFilmPanel getInfoFilmPanel() {
        return this.infoFilmPanel;
    }

    public TitreInfoFilmPanel getTitreInfoFilmPanel() {
        return this.titreInfoFilmPanel;
    }

}
