package gui.recherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchBarPanel extends JPanel {
    private static final String MOVIE_TITLE = "Titre";
    private static final String YEAR_GAP = "Année de sortie (_;_)";
    private static final String COUNTRY = "Pays de production";
    private static final String LANGUAGE = "Langue originale";
    private static final String GENRE = "Genre";
    private static final String DIRECTOR = "Réalisateur";
    private static final String ACTOR = "Acteur";
    private static final int JTF_LENGTH = 11;
    private static final String TOOLTIP_ICON_PATH = "src/gui/tooltipIcon.png";
    private static final String RESEARCH_BUTTON_NAME = "Rechercher";

    private JTextField movieTitleField;
    private JTextField yearGapField;
    private JTextField countryField;
    private JTextField languageField;
    private JTextField genreField;
    private JTextField directorField;
    private JTextField actorField;
    private JPanel yearGapPanel;
    private JPanel movieTitlePanel;
    private JPanel countryPanel;
    private JPanel languagePanel;
    private JPanel genrePanel;
    private JPanel directorPanel;
    private JPanel actorPanel;
    private ImageIcon tooltipIcon;
    private JPanel researchButtonPanel;
    private JButton researchButton;

    public ResearchBarPanel() {
        this.movieTitleField = new JTextField(JTF_LENGTH);
        this.yearGapField = new JTextField(JTF_LENGTH);
        this.countryField = new JTextField(JTF_LENGTH);
        this.languageField = new JTextField(JTF_LENGTH);
        this.genreField = new JTextField(JTF_LENGTH);
        this.directorField = new JTextField(JTF_LENGTH);
        this.actorField = new JTextField(JTF_LENGTH);
        this.movieTitlePanel = new JPanel();
        this.yearGapPanel = new JPanel();
        this.countryPanel = new JPanel();
        this.languagePanel = new JPanel();
        this.genrePanel = new JPanel();
        this.directorPanel = new JPanel();
        this.actorPanel = new JPanel();
        this.tooltipIcon = new ImageIcon(TOOLTIP_ICON_PATH);
        this.researchButtonPanel = new JPanel();
        this.researchButton = new JButton(RESEARCH_BUTTON_NAME);

        this.setLayout(new GridLayout(8, 1));
        setUpPanel(movieTitlePanel, movieTitleField, MOVIE_TITLE, false);
        setUpPanel(yearGapPanel, yearGapField, YEAR_GAP, false);
        setUpPanel(countryPanel, countryField, COUNTRY, false);
        setUpPanel(languagePanel, languageField, LANGUAGE, false);
        setUpPanel(genrePanel, genreField, GENRE, true);
        setUpPanel(directorPanel, directorField, DIRECTOR, true);
        setUpPanel(actorPanel, actorField, ACTOR, true);
        this.researchButtonPanel.add(researchButton);
        this.add(researchButtonPanel);
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

    public JButton getResearchButton() {
        return this.researchButton;
    }
}
