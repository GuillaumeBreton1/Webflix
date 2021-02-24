package gui.recherche.infoPersonne;

import backend.hibernate.tableMapping.PersonnalitePublique;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    private JTextArea biographie;
    private JScrollPane bioScroll;


    public InfoPersonnePanel() {
        this.setLayout(new BorderLayout());
        this.initFixPanel();
        this.initInfoDuFilmPanel();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.add(this.fixPanel, BorderLayout.WEST);
        this.add(this.infoDeLaPersonnePanel);
    }

    public void initFixPanel() {
        JLabel nomF = new JLabel(NOM);
        JLabel dateNaissanceF = new JLabel(DATE_NAISSANCE);
        JLabel lieuNaissancF = new JLabel(LIEU_NAISSANCE);
        JLabel photoF = new JLabel(PHOTO);
        JLabel biographieF = new JLabel(BIOGRAPHIE);

        this.fixPanel = new JPanel();
        this.fixPanel.setBackground(Color.WHITE);
        this.fixPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        this.fixPanel.setLayout(new GridLayout(12, 1));
        this.fixPanel.setPreferredSize(new Dimension(200, 700));
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
        this.biographie = new JTextArea(5,500);
        this.bioScroll = new JScrollPane(this.biographie);
        //this.biographie.setPreferredSize(new Dimension(200,500));
        this.infoDeLaPersonnePanel = new JPanel();
        this.infoDeLaPersonnePanel.setBackground(Color.WHITE);
        this.infoDeLaPersonnePanel.setBorder(new EmptyBorder(0, 0, 0, 10));
        this.infoDeLaPersonnePanel.setLayout(new GridLayout(12, 1));
        this.infoDeLaPersonnePanel.add(this.nom);
        this.infoDeLaPersonnePanel.add(this.dateNaissance);
        this.infoDeLaPersonnePanel.add(this.lieuNaissance);
        this.infoDeLaPersonnePanel.add(this.photo);
        this.infoDeLaPersonnePanel.add(this.bioScroll);
    }

    public void setInfoDeLaPersonne(PersonnalitePublique personne) {
        this.nom.setText(personne.getNom());
        this.dateNaissance.setText(personne.getDateNaissance().toString());
        this.lieuNaissance.setText(personne.getProvenance());
        this.photo.setText(personne.getLienPhoto());
        try{
            this.biographie.setText(personne.getBiographie().getSubString(1,(int)personne.getBiographie().length()));
        }catch(Exception e){

        }
    }

}
