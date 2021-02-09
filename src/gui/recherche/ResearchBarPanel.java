package gui.recherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ResearchBarPanel extends JPanel {
    private static final String MOVIE_TITLE = "Titre";
    private static final String YEAR_GAP = "Année de sortie (_;_)";
    private static final String COUNTRY = "Pays de production";
    private static final String LANGUAGE = "Langue originale";
    private static final String GENRE = "Genre";
    private static final String DIRECTOR = "Réalisateur";
    private static final String ACTOR = "Acteur";
    private static final int JTF_LENGTH = 11;

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

        this.setLayout(new GridLayout(7, 1));
        setUpPanel(movieTitlePanel, movieTitleField, MOVIE_TITLE);
        setUpPanel(yearGapPanel, yearGapField, YEAR_GAP);
        setUpPanel(countryPanel, countryField, COUNTRY);
        setUpPanel(languagePanel, languageField, LANGUAGE);
        setUpPanel(genrePanel, genreField, GENRE);
        setUpPanel(directorPanel, directorField, DIRECTOR);
        setUpPanel(actorPanel, actorField, ACTOR);
        System.out.println(this.getSize());
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
}
