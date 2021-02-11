package gui.recherche.infoFilm;

import javax.swing.*;
import java.awt.*;

public class TitreInfoFilmPanel extends JPanel {

    private JLabel titreFilm;

    public TitreInfoFilmPanel() {
        this.titreFilm = new JLabel();
        this.titreFilm.setFont(new Font(this.titreFilm.getFont().getFontName(), Font.BOLD, 20));
        this.titreFilm.setForeground(Color.GRAY);
        this.add(this.titreFilm);
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm.setText(titreFilm);
    }

}
