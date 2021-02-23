package gui.location;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InfoLocationPanel extends JPanel {
    private static final String FILM = "Film : ";
    private static final String DATE_LOCATION = "Date de location : ";
    private static final String DATE_RETOUR = "Date de retour : ";
    private static final String ETAT = "État : ";


    private JPanel fixPanel;
    private JPanel infoDeLaPersonnePanel;
    private JLabel film;
    private JLabel dateLocation;
    private JLabel dateRetour;
    private JLabel etat;


    public InfoLocationPanel() {
        this.setLayout(new BorderLayout());
        this.initFixPanel();
        this.initInfoLocationPanel();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.add(this.fixPanel, BorderLayout.WEST);
        this.add(this.infoDeLaPersonnePanel);
    }

    public void initFixPanel() {
        JLabel nomF = new JLabel(FILM);
        JLabel dateNaissanceF = new JLabel(DATE_LOCATION);
        JLabel lieuNaissancF = new JLabel(DATE_RETOUR);
        JLabel etat = new JLabel(ETAT);


        this.fixPanel = new JPanel();
        this.fixPanel.setBackground(Color.WHITE);
        this.fixPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        this.fixPanel.setLayout(new GridLayout(12, 1));
        this.fixPanel.setPreferredSize(new Dimension(200, 300));
        this.fixPanel.add(nomF);
        this.fixPanel.add(dateNaissanceF);
        this.fixPanel.add(lieuNaissancF);
        this.fixPanel.add(etat);

    }

    public void initInfoLocationPanel() {
        this.film = new JLabel();
        this.dateLocation = new JLabel();
        this.dateRetour = new JLabel();
        this.etat = new JLabel(); 

        this.infoDeLaPersonnePanel = new JPanel();
        this.infoDeLaPersonnePanel.setBackground(Color.WHITE);
        this.infoDeLaPersonnePanel.setBorder(new EmptyBorder(0, 0, 0, 10));
        this.infoDeLaPersonnePanel.setLayout(new GridLayout(12, 1));
        this.infoDeLaPersonnePanel.add(this.film);
        this.infoDeLaPersonnePanel.add(this.dateLocation);
        this.infoDeLaPersonnePanel.add(this.dateRetour);
        this.infoDeLaPersonnePanel.add(this.etat);


    }

    public void updateInfo(String location){
        this.setInfoLocation(location);
        this.validate();
        this.repaint();
    }

    public void setInfoLocation(String location) {
        this.film.setText(location);
        this.dateLocation.setText(location);
        this.dateRetour.setText(location);
        this.etat.setText(location);
    }
}
