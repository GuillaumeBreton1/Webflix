package gui.recherche.pageRecherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PageDeRecherchePanel extends JPanel {

    private TitreRecherchePanel titreRecherchePanel;
    private BarreDeRecherchePanel barreDeRecherchePanel;
    private ResultatsPanel resultatsPanel;
    private ArrayList<String> liste = new ArrayList<>() {
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

    public PageDeRecherchePanel() {
        this.titreRecherchePanel = new TitreRecherchePanel();
        this.barreDeRecherchePanel = new BarreDeRecherchePanel();
        this.resultatsPanel = new ResultatsPanel(liste);
        this.setLayout(new BorderLayout(10, 10));
        this.add(this.titreRecherchePanel, BorderLayout.NORTH);
        this.add(this.barreDeRecherchePanel, BorderLayout.WEST);
        this.add(this.resultatsPanel, BorderLayout.CENTER);
        this.setUpBoutonRechercheListener(this.resultatsPanel, this);
    }

    public void setUpBoutonRechercheListener(ResultatsPanel resultatsPanel, JPanel jPanel) {
        this.barreDeRecherchePanel.getBoutonRecherche().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatsPanel.montrerResultats();
                jPanel.validate();
                jPanel.repaint();
            }
        });
    }

    public ResultatsPanel getResultsPanel() {
        return this.resultatsPanel;
    }

}
