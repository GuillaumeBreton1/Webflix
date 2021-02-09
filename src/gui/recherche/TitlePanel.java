package gui.recherche;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    private static final String PANEL_TITLE = "Rechercher un film";

    public TitlePanel() {
        JLabel title = new JLabel(PANEL_TITLE);
        title.setFont(new Font(title.getFont().getFontName(), Font.BOLD, 20));
        title.setForeground(Color.GRAY);
        this.add(title);
    }
}
