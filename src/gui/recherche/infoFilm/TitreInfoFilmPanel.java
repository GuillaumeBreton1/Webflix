package gui.recherche.infoFilm;

import backend.hibernate.tableMapping.Film;
import gui.recherche.Listener.LouerListener;
import gui.recherche.Listener.RetourListener;

import javax.swing.*;
import java.awt.*;

public class TitreInfoFilmPanel extends JPanel {

    private static final String RETOUR_ICON_PATH = "src/gui/icon/retourIcon.png";
    private static final String NOM_BOUTON_LOUER = "Louer";

    private ImageIcon retourIcon;
    private JButton louerButton;
    private JLabel retour;
    private JLabel titreFilm;
    private JPanel retourPanel;
    private JPanel louerPanel;
    private JPanel titreFilmPanel;
    private Film filmActuel;

    public TitreInfoFilmPanel() {
        this.setUpRetourPanel();
        this.setUpLouerPanel();
        this.setUpTitrePanel();
        this.setLayout(new BorderLayout());

        this.add(this.retourPanel, BorderLayout.WEST);
        this.add(this.louerPanel, BorderLayout.EAST);
        this.add(this.titreFilmPanel, BorderLayout.CENTER);
    }

    public void setUpRetourPanel() {
        this.retourIcon = new ImageIcon(RETOUR_ICON_PATH);
        this.retour = new JLabel(this.retourIcon);
        this.retourPanel = new JPanel();
        this.retourPanel.add(this.retour);
    }

    public void setUpLouerPanel() {
        this.louerButton = new JButton(NOM_BOUTON_LOUER);
        this.louerPanel = new JPanel();
        this.setUpLouerMouseListener();
        this.louerPanel.add(this.louerButton);
    }

    public void setUpTitrePanel() {
        this.titreFilm = new JLabel();
        this.titreFilm.setFont(new Font(this.titreFilm.getFont().getFontName(), Font.BOLD, 20));
        this.titreFilm.setForeground(Color.GRAY);
        this.titreFilm.setHorizontalTextPosition(JLabel.LEFT);
        this.titreFilmPanel = new JPanel();
        this.titreFilmPanel.add(this.titreFilm);
    }

    public void setTitreFilm(Film film) {
        this.titreFilm.setText(film.getTitre());
        this.filmActuel = film;
    }

    public void setUpRetourMouseListener(RetourListener retourListener) {
        this.retour.addMouseListener(retourListener);
    }

    public void setUpLouerMouseListener() {
        this.louerButton.addMouseListener(new LouerListener(this));
    }

    public Film getFilmActuel(){
        return filmActuel;
    }

}
