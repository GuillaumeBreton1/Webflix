package gui.recherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(DIMENSION);
        this.add(this.titlePanel, BorderLayout.NORTH);
        this.add(this.researchBarPanel, BorderLayout.WEST);
        this.add(this.resultsPanel, BorderLayout.CENTER);
        this.setVisible(true);
        this.setUpResearchButtonListener(this.resultsPanel, this);

    }

    public void setUpResearchButtonListener(ResultsPanel resultsPanel, JFrame jFrame) {
        this.researchBarPanel.getResearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsPanel.showResults();
                jFrame.validate();
                jFrame.repaint();
            }
        });
    }
}
