package gui.recherche.infoFilm;

import backend.hibernate.tableMapping.Film;
import backend.hibernate.tableMapping.Role;
import backend.hibernate.tableMapping.Scenariste;
import gui.recherche.Listener.PersonneListener;
import gui.recherche.Listener.PersonneListeListener;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Set;

public class InfoFilmPanel extends JPanel {

    private static final String TITRE = "Titre : ";
    private static final String ANNEE_SORTIE = "Année de sortie : ";
    private static final String PAYS_PRODUCTION = "Pays de production : ";
    private static final String LANGUE_ORIGINALE = "Langue originale : ";
    private static final String DUREE = "Durée : ";
    private static final String GENRES = "Genres : ";
    private static final String REALISATEUR = "Réalisateur : ";
    private static final String SCENARISTES = "Scénaristes : ";
    private static final String ACTEURS = "Acteurs : ";
    private static final String RESUME = "Résumé : ";
    private static final String AFFICHE = "Affiche : ";
    private static final String BANDES_ANNONCES = "Bandes-annonces : ";

    // Attribut liste 
    private static final String[] LISTE_PAYS = {"Action", "Horreur", "Comédie"};
    private static final String[] LISTE_GENRES = {"Action", "Horreur", "Comédie"};
    private static final String[] LISTE_ACTEURS = {"Action", "Horreur", "Comédie","Action", "Horreur", "Comédie"};
    private static final String[] LISTE_SCENARISTES = {"Action", "Horreur", "Comédie","Action", "Horreur", "Comédie"};
    private static final String[] LISTE_BANDE_ANNONCES = {"Action", "Horreur", "Comédie"};

    // Scroller 
    private JScrollPane acteursScroll;
    private JScrollPane scenaristesScroll;

    //JLabel
    private JPanel fixPanel;
    private JPanel infoDuFilmPanel;
    private JLabel titre;
    private JLabel annee;
    private JLabel langue;
    private JLabel duree;
    private JLabel realisateur;
    private JLabel scenaristes;
    private JLabel resume;
    private JLabel affiche;
    private JLabel pays;
    private JLabel genres;
    private JLabel bandesAnnonces;

    //JList
    private JList roles;
    private DefaultListModel<Role> listRole = new DefaultListModel<>();

    public InfoFilmPanel() {
        this.setLayout(new BorderLayout());
        this.initFixPanel();
        this.initInfoDuFilmPanel();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY.darker()));
        this.add(this.fixPanel, BorderLayout.WEST);
        this.add(this.infoDuFilmPanel);
    }

    public void initFixPanel() {
        JLabel titreF = new JLabel(TITRE);
        JLabel anneeF = new JLabel(ANNEE_SORTIE);
        JLabel paysF = new JLabel(PAYS_PRODUCTION);
        JLabel langueF = new JLabel(LANGUE_ORIGINALE);
        JLabel dureeF = new JLabel(DUREE);
        JLabel genresF = new JLabel(GENRES);
        JLabel realisateurF = new JLabel(REALISATEUR);
        JLabel scenaristesF = new JLabel(SCENARISTES);
        JLabel acteursF = new JLabel(ACTEURS);
        JLabel resumeF = new JLabel(RESUME);
        JLabel afficheF = new JLabel(AFFICHE);
        JLabel bandesAnnoncesF = new JLabel(BANDES_ANNONCES);

        this.fixPanel = new JPanel();
        this.fixPanel.setBackground(Color.WHITE);
        this.fixPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        this.fixPanel.setLayout(new GridLayout(12, 1));
        this.fixPanel.setPreferredSize(new Dimension(200, 700));
        this.fixPanel.add(titreF);
        this.fixPanel.add(anneeF);
        this.fixPanel.add(paysF);
        this.fixPanel.add(langueF);
        this.fixPanel.add(dureeF);
        this.fixPanel.add(genresF);
        this.fixPanel.add(realisateurF);
        this.fixPanel.add(scenaristesF);
        this.fixPanel.add(acteursF);
        this.fixPanel.add(resumeF);
        this.fixPanel.add(afficheF);
        this.fixPanel.add(bandesAnnoncesF);
    }

    public void initInfoDuFilmPanel() {
        this.titre = new JLabel();
        this.annee = new JLabel();
        this.pays = new JLabel();
        this.langue = new JLabel();
        this.duree = new JLabel();
        this.genres = new JLabel();
        this.realisateur = new JLabel();
        this.resume = new JLabel();
        this.affiche = new JLabel();
        this.bandesAnnonces = new JLabel();
        this.scenaristes = new JLabel();

        this.roles = new JList(this.listRole);
        this.roles.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.roles.setVisibleRowCount(-1);
        this.acteursScroll = new JScrollPane(this.roles);
        this.acteursScroll.setPreferredSize(new Dimension(250, 80));

        this.realisateur.setForeground(Color.BLUE);
        this.roles.setForeground(Color.BLUE);


        this.realisateur.setForeground(Color.BLUE);
        this.infoDuFilmPanel = new JPanel();
        this.infoDuFilmPanel.setBackground(Color.WHITE);
        this.infoDuFilmPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
        this.infoDuFilmPanel.setLayout(new GridLayout(12, 1));
        this.infoDuFilmPanel.add(this.titre);
        this.infoDuFilmPanel.add(this.annee);
        this.infoDuFilmPanel.add(this.pays);
        this.infoDuFilmPanel.add(this.langue);
        this.infoDuFilmPanel.add(this.duree);
        this.infoDuFilmPanel.add(this.genres);
        this.infoDuFilmPanel.add(this.realisateur);
        this.infoDuFilmPanel.add(this.scenaristes);
        this.infoDuFilmPanel.add(this.acteursScroll);
        this.infoDuFilmPanel.add(this.resume);
        this.infoDuFilmPanel.add(this.affiche);
        this.infoDuFilmPanel.add(this.bandesAnnonces);

    }

    public void setInfoDuFilm(Film film) {
        listRole.clear();
        listRole.addAll(film.getRoles());

        //On set les attributs uniques
        this.titre.setText(film.getTitre());
        this.annee.setText(film.getDateSortie().toString());
        this.langue.setText(film.getLangueOriginale());
        this.duree.setText(film.getDuree().toString());
        this.realisateur.putClientProperty("personne", film.getRealisateur());
        this.realisateur.setText(film.getRealisateur().getNom());
        this.scenaristes.setText(film.getScenaristes().toString());
        this.resume.setText(film.getResumeScenario());
        this.affiche.setText(film.getLienAffiche());

        //On set les attributs en liste non selectionnable 
        this.setInfoListe(film.getPays(), this.pays);
        //this.setInfoListe(film.get, this.bandesAnnonces);
        this.setInfoListe(film.getGenres(), this.genres);
        this.setInfoListe(film.getScenaristes(), this.scenaristes);

    }


    public void setInfoListe(Set liste, JLabel label){

        String strListe = new String("");
        int i = 0; 

        for(Object p : liste){
            i++; 
            if(i < liste.size()){
                strListe += p.toString() + ", ";
            }else{
                strListe += p.toString();
            }

        }

        label.setText(strListe);
    }

    public void setUpPersonneMouseListener(PersonneListener personneListener,PersonneListeListener personneListeListener) {
        this.realisateur.addMouseListener(personneListener);
        this.roles.addMouseListener(personneListeListener);
    }

}
