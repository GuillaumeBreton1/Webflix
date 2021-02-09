package gui.recherche;

import javax.swing.*;
import java.awt.*;

public class ResearchBarPanel extends JPanel {
    private static final String PANEL_TITLE = "Rechercher un film";
    private static final String MOVIE_TITLE = "Titre du film";
    private static final String MOVIE_TITLE = "Titre du film";



    private JTextField movieTitleField;
    private JTextField yearMinField;
    private JTextField yearMaxField;
    private Container yearGapContainer;
    private Container movieTitleContainer;



    public ResearchBarPanel() {
        setTitle();
    }

    public void setTitle() {
        JLabel title = new JLabel(PANEL_TITLE);
        this.add(title);
    }
}
