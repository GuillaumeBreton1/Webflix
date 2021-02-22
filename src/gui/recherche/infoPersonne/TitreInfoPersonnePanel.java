package gui.recherche.infoPersonne;

import gui.recherche.Listener.RetourListener;

import javax.swing.*;
import java.awt.*;

public class TitreInfoPersonnePanel extends JPanel {

    private static final String RETOUR_ICON_PATH = "src/gui/icon/retourIcon.png";

    private ImageIcon retourIcon;
    private JLabel retour;
    private JLabel nomPersonne;
    private JPanel retourPanel;
    private JPanel nomPersonnePanel;

    public TitreInfoPersonnePanel() {
        this.setUpRetourPanel();
        this.setUpNomPersonnePanel();
        this.setLayout(new BorderLayout());

        this.add(this.retourPanel, BorderLayout.WEST);
        this.add(this.nomPersonnePanel, BorderLayout.CENTER);
    }

    public void setUpRetourPanel() {
        this.retourIcon = new ImageIcon(RETOUR_ICON_PATH);
        this.retour = new JLabel();
        this.retour.setIcon(retourIcon);
        this.retourPanel = new JPanel();
        this.retourPanel.add(this.retour);
    }

    public void setUpNomPersonnePanel() {
        this.nomPersonne = new JLabel();
        this.nomPersonne.setFont(new Font(this.nomPersonne.getFont().getFontName(), Font.BOLD, 20));
        this.nomPersonne.setForeground(Color.GRAY);
        this.nomPersonne.setHorizontalTextPosition(JLabel.LEFT);
        this.nomPersonnePanel = new JPanel();
        this.nomPersonnePanel.add(this.nomPersonne);
    }

    public void setNomPersonne(String titreFilm) {
        this.nomPersonne.setText(titreFilm);
    }

    public void setUpRetourMouseListener(RetourListener retourListener) {
        this.retour.addMouseListener(retourListener);
    }
}
