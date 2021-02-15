package gui.recherche.pageRecherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BarreDeRecherchePanel extends JPanel {
    private static final String TITRE_FILM = "Titre";
    private static final String GAP_ANNEE = "Année de sortie (_;_)";
    private static final String PAYS = "Pays de production";
    private static final String LANGUE = "Langue originale";
    private static final String GENRE = "Genre";
    private static final String REALISATEUR = "Réalisateur";
    private static final String ACTEUR = "Acteur";
    private static final int JTF_LENGTH = 11;
    private static final String TOOLTIP_ICON_PATH = "src/gui/icon/tooltipIcon.png";
    private static final String NOM_BOUTON_RECHERCHE = "Rechercher";

    private JTextField titreFilmField;
    private JTextField gapAnneeField;
    private JTextField paysField;
    private JTextField langueField;
    private JTextField genreField;
    private JTextField realisateurField;
    private JTextField acteurField;
    private JPanel titreFilmPanel;
    private JPanel gapAnneePanel;
    private JPanel paysPanel;
    private JPanel languePanel;
    private JPanel genrePanel;
    private JPanel realisateurPanel;
    private JPanel acteurPanel;
    private ImageIcon tooltipIcon;
    private JPanel boutonRecherchePanel;
    private JButton boutonRecherche;

    public BarreDeRecherchePanel() {
        this.titreFilmField = new JTextField(JTF_LENGTH);
        this.gapAnneeField = new JTextField(JTF_LENGTH);
        this.paysField = new JTextField(JTF_LENGTH);
        this.langueField = new JTextField(JTF_LENGTH);
        this.genreField = new JTextField(JTF_LENGTH);
        this.realisateurField = new JTextField(JTF_LENGTH);
        this.acteurField = new JTextField(JTF_LENGTH);
        this.titreFilmPanel = new JPanel();
        this.gapAnneePanel = new JPanel();
        this.paysPanel = new JPanel();
        this.languePanel = new JPanel();
        this.genrePanel = new JPanel();
        this.realisateurPanel = new JPanel();
        this.acteurPanel = new JPanel();
        this.tooltipIcon = new ImageIcon(TOOLTIP_ICON_PATH);
        this.boutonRecherchePanel = new JPanel();
        this.boutonRecherche = new JButton(NOM_BOUTON_RECHERCHE);

        this.setLayout(new GridLayout(8, 1));
        setUpPanel(titreFilmPanel, titreFilmField, TITRE_FILM, false);
        setUpPanel(gapAnneePanel, gapAnneeField, GAP_ANNEE, false);
        setUpPanel(paysPanel, paysField, PAYS, false);
        setUpPanel(languePanel, langueField, LANGUE, false);
        setUpPanel(genrePanel, genreField, GENRE, true);
        setUpPanel(realisateurPanel, realisateurField, REALISATEUR, true);
        setUpPanel(acteurPanel, acteurField, ACTEUR, true);
        this.boutonRecherchePanel.add(boutonRecherche);
        this.add(boutonRecherchePanel);
    }

    public void setLabel(JPanel panel, String label, Boolean needsTooltip) {
        JLabel title = new JLabel(label);
        if(needsTooltip) {
            title.setIcon(this.tooltipIcon);
            title.setVerticalTextPosition(JLabel.CENTER);
            title.setHorizontalTextPosition(JLabel.LEFT);
            title.setToolTipText("Pour entrer plusieurs valeurs, séparez les éléments par des virgules.");
        }
        panel.add(title);
    }

    public void setUpPanel(JPanel panel, JTextField jTextField, String label, Boolean needsTooltip) {
        panel.setLayout(new GridLayout(3, 1));
        this.setLabel(panel, label, needsTooltip);
        panel.add(jTextField);
        panel.setBorder(new EmptyBorder(0, 10, 0, 0));
        this.add(panel);
    }

    public JButton getBoutonRecherche() {
        return this.boutonRecherche;
    }
}
