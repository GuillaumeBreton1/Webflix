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
        this.infoFilmPanel.setBorder(new EmptyBorder(0, 10, 0,10));
        this.setLayout(new BorderLayout(10, 10));
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

}
