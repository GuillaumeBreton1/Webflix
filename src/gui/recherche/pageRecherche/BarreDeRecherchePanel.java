package gui.recherche.pageRecherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BarreDeRecherchePanel extends JPanel {
    private static final String TITRE_FILM = "Titre";
    private static final String GAP_ANNEE = "Année de sortie (_;_)";
    private static final String PAYS = "Pays de production";
    private static final String LANGUE = "Langue originale";
    private static final String GENRE = "Genre";
    private static final String REALISATEUR = "Réalisateur";
    private static final String ACTEUR = "Acteur";
    private static final int JTF_LENGTH = 11;
    private static final String NOM_BOUTON_RECHERCHE = "Rechercher";
    private static final String AND = "Inclut tout les critères";
    private static final String OR = "Inclut au moins un des critères";


    private JTextField titreFilmField;
    private JTextField gapAnneeField;
    private JTextField paysField;
    private JTextField langueField;
    private JTextField genreField;
    private JTextField realisateurField;
    private JTextField acteurField;
    private JRadioButton andRadioButton;
    private JRadioButton orRadioButton;
    private JButton boutonRecherche;
    private JPanel titreFilmPanel;
    private JPanel gapAnneePanel;
    private JPanel paysPanel;
    private JPanel languePanel;
    private JPanel genrePanel;
    private JPanel realisateurPanel;
    private JPanel acteurPanel;
    private JPanel radioButtonPanel;
    private JPanel boutonRecherchePanel;


    public BarreDeRecherchePanel() {
        this.titreFilmField = new JTextField(JTF_LENGTH);
        this.gapAnneeField = new JTextField(JTF_LENGTH);
        this.paysField = new JTextField(JTF_LENGTH);
        this.langueField = new JTextField(JTF_LENGTH);
        this.genreField = new JTextField(JTF_LENGTH);
        this.realisateurField = new JTextField(JTF_LENGTH);
        this.acteurField = new JTextField(JTF_LENGTH);
        this.andRadioButton = new JRadioButton(AND);
        this.orRadioButton = new JRadioButton(OR);
        this.titreFilmPanel = new JPanel();
        this.gapAnneePanel = new JPanel();
        this.paysPanel = new JPanel();
        this.languePanel = new JPanel();
        this.genrePanel = new JPanel();
        this.realisateurPanel = new JPanel();
        this.acteurPanel = new JPanel();
        this.boutonRecherchePanel = new JPanel();
        this.radioButtonPanel = new JPanel();
        this.boutonRecherche = new JButton(NOM_BOUTON_RECHERCHE);

        this.setLayout(new GridLayout(9, 1));
        this.setUpPanel(titreFilmPanel, titreFilmField, TITRE_FILM);
        this.setUpPanel(gapAnneePanel, gapAnneeField, GAP_ANNEE);
        this.setUpPanel(paysPanel, paysField, PAYS);
        this.setUpPanel(languePanel, langueField, LANGUE);
        this.setUpPanel(genrePanel, genreField, GENRE);
        this.setUpPanel(realisateurPanel, realisateurField, REALISATEUR);
        this.setUpPanel(acteurPanel, acteurField, ACTEUR);
        this.setUpRadioButton(this.andRadioButton, true);
        this.setUpRadioButton(this.orRadioButton, false);
        this.setUpButtonGroup();
        this.radioButtonPanel.setLayout(new GridLayout(2, 1));
        this.radioButtonPanel.setBorder(new EmptyBorder(0,10,0,0));
        this.radioButtonPanel.add(this.andRadioButton);
        this.radioButtonPanel.add(this.orRadioButton);
        this.add(this.radioButtonPanel);
        this.boutonRecherchePanel.add(boutonRecherche);
        this.add(this.boutonRecherchePanel);
    }

    public void setLabel(JPanel panel, String label) {
        JLabel title = new JLabel(label);
        panel.add(title);
    }

    public void setUpPanel(JPanel panel, JTextField jTextField, String label) {
        panel.setLayout(new GridLayout(3, 1));
        this.setLabel(panel, label);
        panel.add(jTextField);
        panel.setBorder(new EmptyBorder(0, 10, 0, 0));
        this.add(panel);
    }

    public JButton getBoutonRecherche() {
        return this.boutonRecherche;
    }

    public void setUpRadioButton(JRadioButton radioButton, Boolean selected) {
        radioButton.setMnemonic(KeyEvent.VK_B);
        radioButton.setSelected(selected);
    }

    public void setUpButtonGroup() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.andRadioButton);
        buttonGroup.add(this.orRadioButton);
    }
}
