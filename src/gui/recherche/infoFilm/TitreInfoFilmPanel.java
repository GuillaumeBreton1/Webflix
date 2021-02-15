package gui.recherche.infoFilm;

import gui.recherche.Listener.RetourListener;

import javax.swing.*;
import java.awt.*;

public class TitreInfoFilmPanel extends JPanel {

    private static final String RETOUR_ICON_PATH = "src/gui/icon/retourIcon.png";

    private ImageIcon retourIcon;
    private JLabel retour;
    private JLabel titreFilm;
    private JPanel retourPanel;
    private JPanel titreFilmPanel;

    public TitreInfoFilmPanel() {
        this.setUpRetourPanel();
        this.setUpTitrePanel();
        this.setLayout(new BorderLayout());

        this.add(this.retourPanel, BorderLayout.WEST);
        this.add(this.titreFilmPanel, BorderLayout.CENTER);
    }

    public void setUpRetourPanel() {
        this.retourIcon = new ImageIcon(RETOUR_ICON_PATH);
        this.retour = new JLabel(this.retourIcon);
        this.retourPanel = new JPanel();
        this.retourPanel.add(this.retour);
    }

    public void setUpTitrePanel() {
        this.titreFilm = new JLabel();
        this.titreFilm.setFont(new Font(this.titreFilm.getFont().getFontName(), Font.BOLD, 20));
        this.titreFilm.setForeground(Color.GRAY);
        this.titreFilm.setHorizontalTextPosition(JLabel.LEFT);
        this.titreFilmPanel = new JPanel();
        this.titreFilmPanel.add(this.titreFilm);
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm.setText(titreFilm);
    }

    public void setUpRetourMouseListener(RetourListener retourListener) {
        this.retour.addMouseListener(retourListener);
    }

}
