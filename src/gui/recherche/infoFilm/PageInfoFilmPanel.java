package gui.recherche.infoFilm;

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
        this.setBorder(new EmptyBorder(0, 40, 0, 40));
        this.add(this.titreInfoFilmPanel, BorderLayout.NORTH);
        this.add(this.infoFilmPanel);
    }

    public void setMovie(String movieTitle) {
        this.titreInfoFilmPanel.setTitreFilm(movieTitle);
        this.infoFilmPanel.setInfoDuFilm();
    }

    public InfoFilmPanel getInfoFilmPanel() {
        return this.infoFilmPanel;
    }

    public TitreInfoFilmPanel getTitreInfoFilmPanel() {
        return this.titreInfoFilmPanel;
    }

}
