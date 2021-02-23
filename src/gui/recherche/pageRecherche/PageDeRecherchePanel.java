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
        this.resultatsPanel = new ResultatsPanel();
        this.setLayout(new BorderLayout(10, 10));
        this.add(this.titreRecherchePanel, BorderLayout.NORTH);
        this.add(this.barreDeRecherchePanel, BorderLayout.WEST);
        this.add(this.resultatsPanel, BorderLayout.CENTER);
        this.setUpBoutonRechercheListener(this.resultatsPanel, this, this.liste);
    }

    public void setUpBoutonRechercheListener(ResultatsPanel resultatsPanel, JPanel jPanel, ArrayList<String> liste) {
        this.barreDeRecherchePanel.getBoutonRecherche().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!liste.isEmpty()) {
                    // ICI POUR METTRE LA LISTE DES FILMS OBTENUES PAR SELECT SUR LA BD 
                    resultatsPanel.montrerResultats(liste);
                    jPanel.validate();
                    jPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(jPanel, "Aucun résultat n'a été trouvé pour ses critères");
                }
            }
        });
    }

    public ResultatsPanel getResultsPanel() {
        return this.resultatsPanel;
    }

    public JButton getLogoutButton(){
        return this.titreRecherchePanel.getLogoutButton(); 
    }

    public JButton getLocationButton(){
        return this.titreRecherchePanel.getLocationButton(); 
    }

    public void clearTextField(){
        this.barreDeRecherchePanel.clearTextField();
    }

}
