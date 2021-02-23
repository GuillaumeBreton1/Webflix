package gui.location;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PageLocationPanel extends JPanel {

    private TitreLocationPanel titreLocationPanel;
    private ResultatLocationPanel resultatLocationPanel;

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

    public PageLocationPanel() {
        this.titreLocationPanel = new TitreLocationPanel();
        this.resultatLocationPanel = new ResultatLocationPanel(); 
        this.titreLocationPanel.setSize(new Dimension(700,50));
        this.resultatLocationPanel.setSize(new Dimension(700,600));
        this.setLayout(new BorderLayout(10, 10));
        this.add(this.titreLocationPanel, BorderLayout.NORTH);
        this.add(this.resultatLocationPanel, BorderLayout.SOUTH);
        this.loadLocation();
    }

    public void loadLocation(){
        // Changer liste pour la liste des locations obtenues dans la BD 
        this.resultatLocationPanel.montrerResultats(liste);
        this.validate();
        this.repaint();
    }

    public TitreLocationPanel getTitreLocationPanel(){
        return this.titreLocationPanel; 
    }

}
