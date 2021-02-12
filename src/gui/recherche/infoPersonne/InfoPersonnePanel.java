package gui.recherche.infoPersonne;

import javax.swing.*;
import java.awt.*;

public class InfoPersonnePanel extends JPanel {

    private static final String NOM = "Nom : ";
    private static final String DATE_NAISSANCE = "Date de naissance : ";
    private static final String LIEU_NAISSANCE = "Lieu de naissance : ";
    private static final String PHOTO = "Photo : ";
    private static final String BIOGRAPHIE = "Biographie : ";

    private JPanel fixPanel;
    private JPanel infoDeLaPersonnePanel;
    private JLabel nom;
    private JLabel dateNaissance;
    private JLabel lieuNaissance;
    private JLabel photo;
    private JLabel biographie;


    public InfoPersonnePanel() {
        this.setLayout(new GridLayout(1, 2));
        this.initFixPanel();
        this.initInfoDuFilmPanel();
        this.fixPanel.setPreferredSize(new Dimension(200, 700));
        this.add(this.fixPanel);
        this.add(this.infoDeLaPersonnePanel);
    }

    public void initFixPanel() {
        JLabel nomF = new JLabel(NOM);
        JLabel dateNaissanceF = new JLabel(DATE_NAISSANCE);
        JLabel lieuNaissancF = new JLabel(LIEU_NAISSANCE);
        JLabel photoF = new JLabel(PHOTO);
        JLabel biographieF = new JLabel(BIOGRAPHIE);

        this.fixPanel = new JPanel();
        this.fixPanel.setLayout(new GridLayout(12, 1));
        this.fixPanel.add(nomF);
        this.fixPanel.add(dateNaissanceF);
        this.fixPanel.add(lieuNaissancF);
        this.fixPanel.add(photoF);
        this.fixPanel.add(biographieF);
    }

    public void initInfoDuFilmPanel() {
        this.nom = new JLabel();
        this.dateNaissance = new JLabel();
        this.lieuNaissance = new JLabel();
        this.photo = new JLabel();
        this.biographie = new JLabel();

        this.infoDeLaPersonnePanel = new JPanel();
        this.infoDeLaPersonnePanel.setLayout(new GridLayout(12, 1));
        this.infoDeLaPersonnePanel.add(this.nom);
        this.infoDeLaPersonnePanel.add(this.dateNaissance);
        this.infoDeLaPersonnePanel.add(this.lieuNaissance);
        this.infoDeLaPersonnePanel.add(this.photo);
        this.infoDeLaPersonnePanel.add(this.biographie);
    }

    public void setInfoDeLaPersonne() {
        this.nom.setText("test");
        this.dateNaissance.setText("est");
        this.lieuNaissance.setText("hfjjkh");
        this.photo.setText("fkhhhjj");
        this.biographie.setText("ueujj");
    }

}
