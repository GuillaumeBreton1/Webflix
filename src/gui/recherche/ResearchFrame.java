package gui.recherche;

import javax.swing.*;
import java.awt.*;

public class ResearchFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Webflix";
    private static final Dimension DIMENSION = new Dimension(700, 700);

    public ResearchFrame() {

        setVisible(true);
        setTitle(TITRE_FENETRE);

        // Mettre la fenetre au centre de l'ecran
        setLocationRelativeTo(null);

        // Empecher la redimension de la fenetre
        setResizable(false);
        setSize(DIMENSION);

    }
}
