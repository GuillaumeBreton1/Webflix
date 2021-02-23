package gui.recherche.pageRecherche;

import javax.swing.*;
import java.awt.*;

public class TitreRecherchePanel extends JPanel {
    private static final String TITRE_PANEL = "Rechercher un film";

    private JPanel titrePanel;
    private JButton logoutButton = new JButton("Logout");
    private JButton locationButton = new JButton("Location");
    
    public TitreRecherchePanel() {
        this.setUpTitrePanel();
        this.setLayout(new BorderLayout());
        this.add(this.locationButton, BorderLayout.WEST);
        this.add(this.titrePanel, BorderLayout.CENTER);
        this.add(this.logoutButton, BorderLayout.EAST);

    }

    /*
    public void setUpTooltipPanel() {
        JLabel tooltipLabel = new JLabel(this.tooltipIcon);
        tooltipLabel.setHorizontalAlignment(JLabel.CENTER);
        tooltipLabel.setVerticalAlignment(JLabel.CENTER);
        tooltipLabel.setToolTipText("Pour entrer plusieurs valeurs dans un champ, séparez les éléments par des virgules.");
        this.tooltipPanel = new JPanel();
        this.tooltipPanel.add(tooltipLabel);
    }*/

    public void setUpTitrePanel() {
        JLabel titre = new JLabel(TITRE_PANEL);
        titre.setFont(new Font(titre.getFont().getFontName(), Font.BOLD, 20));
        titre.setForeground(Color.GRAY);
        this.titrePanel = new JPanel();
        this.titrePanel.add(titre);
    }

    public JButton getLogoutButton(){
        return this.logoutButton; 
    }

    public JButton getLocationButton(){
        return this.locationButton; 
    }
}
