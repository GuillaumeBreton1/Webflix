package gui.recherche;

import javax.swing.*;
import java.awt.*;

public class ResearchFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Webflix";
    private static final Dimension DIMENSION = new Dimension(700, 700);

    private JPanel cards;
    private ResearchPagePanel researchPagePanel;
    private MovieInfoPagePanel movieInfoPagePanel;
    private PersonInfoPagePanel personInfoPagePanel;

    public ResearchFrame() {
        this.cards = new JPanel(new CardLayout());
        this.researchPagePanel = new ResearchPagePanel();
        this.movieInfoPagePanel = new MovieInfoPagePanel();
        this.personInfoPagePanel = new PersonInfoPagePanel();
        setTitle(TITRE_FENETRE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(DIMENSION);
        this.cards.add(this.researchPagePanel);
        this.cards.add(this.movieInfoPagePanel);
        this.cards.add(this.personInfoPagePanel);
        this.add(cards);
        this.setVisible(true);
    }
}
