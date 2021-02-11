package gui.recherche.infoPersonne;

import javax.swing.*;
import java.awt.*;

public class TitreInfoPersonnePanel extends JPanel {

    private JLabel nomPersonne;

    public TitreInfoPersonnePanel() {
        this.nomPersonne = new JLabel();
        this.nomPersonne.setFont(new Font(this.nomPersonne.getFont().getFontName(), Font.BOLD, 20));
        this.nomPersonne.setForeground(Color.GRAY);
        this.add(this.nomPersonne);
    }

    public void setNomPersonne(String titreFilm) {
        this.nomPersonne.setText(titreFilm);
    }
}
