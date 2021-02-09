package gui.recherche;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResearchFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Webflix";
    private static final Dimension DIMENSION = new Dimension(700, 700);

    private TitlePanel titlePanel;
    private ResearchBarPanel researchBarPanel;
    private ResultsPanel resultsPanel;
    private ArrayList<String> list = new ArrayList<>() {
        {
            add("allo");
            add("allo1");
            add("allo2");
            add("allo");
            add("allo1");
            add("allo2");
            add("allo");
            add("allo1");
            add("allo2");
        }
    };


    public ResearchFrame() {
        this.titlePanel = new TitlePanel();
        this.researchBarPanel = new ResearchBarPanel();
        this.resultsPanel = new ResultsPanel(list);
        setTitle(TITRE_FENETRE);

        // Mettre la fenetre au centre de l'ecran
        setLocationRelativeTo(null);

        // Empecher la redimension de la fenetre
        setResizable(false);
        setSize(DIMENSION);
        this.add(this.titlePanel, BorderLayout.NORTH);
        this.add(this.researchBarPanel, BorderLayout.WEST);
        this.add(this.resultsPanel, BorderLayout.CENTER);
        this.setVisible(true);


    }
}
