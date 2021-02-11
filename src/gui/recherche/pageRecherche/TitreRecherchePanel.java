package gui.recherche.pageRecherche;

import javax.swing.*;
import java.awt.*;

public class TitreRecherchePanel extends JPanel {
    private static final String TITRE_PANEL = "Rechercher un film";

    public TitreRecherchePanel() {
        JLabel title = new JLabel(TITRE_PANEL);
        title.setFont(new Font(title.getFont().getFontName(), Font.BOLD, 20));
        title.setForeground(Color.GRAY);
        this.add(title);
    }
}
