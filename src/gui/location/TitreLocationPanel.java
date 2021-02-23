package gui.location;

import javax.swing.*;

import gui.recherche.Listener.RetourLocationListener;

import java.awt.*;

public class TitreLocationPanel extends JPanel {
    private static final String TITRE_PANEL = "Location";
    private static final String RETOUR_ICON_PATH = "src/gui/icon/retourIcon.png";

    private JPanel retourPanel;
    private JPanel titrePanel;
    private JLabel retour;
    private ImageIcon retourIcon;
    
    public TitreLocationPanel() {

        this.setUpRetourPanel();
        this.setUpTitrePanel();
        this.setLayout(new BorderLayout());
        this.add(this.retourPanel, BorderLayout.WEST);
        this.add(this.titrePanel, BorderLayout.CENTER);
    }

    public void setUpRetourPanel() {
        this.retourIcon = new ImageIcon(RETOUR_ICON_PATH);
        this.retour = new JLabel();
        this.retour.setIcon(retourIcon);
        this.retourPanel = new JPanel();
        this.retourPanel.add(this.retour);
    }

    public void setUpTitrePanel() {
        JLabel titre = new JLabel(TITRE_PANEL);
        titre.setFont(new Font(titre.getFont().getFontName(), Font.BOLD, 20));
        titre.setForeground(Color.GRAY);
        this.titrePanel = new JPanel();
        this.titrePanel.add(titre);
    }

    public void setUpListeResultatsSelectionListener(){
        
    }
    public void setUpRetourMouseListener(RetourLocationListener retourListener) {
        this.retour.addMouseListener(retourListener);
    }
    
}
