package gui.recherche.infoFilm;

import gui.recherche.Listener.PersonneListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoFilmPanel extends JPanel {
    private static final String TITRE = "Titre : ";
    private static final String ANNEE_SORTIE = "Année de sortie : ";
    private static final String PAYS_PRODUCTION = "Pays de protduction : ";
    private static final String LANGUE_ORIGINALE = "Langue originale : ";
    private static final String DUREE = "Durée : ";
    private static final String GENRES = "Genres : ";
    private static final String REALISATEUR = "Réalisateur : ";
    private static final String SCENARISTES = "Snénaristes : ";
    private static final String ACTEURS = "Acteurs : ";
    private static final String RESUME = "Résumé : ";
    private static final String AFFICHE = "Affiche : ";
    private static final String BANDES_ANNONCES = "Bandes-annonces : ";

    private JPanel fixPanel;
    private JPanel infoDuFilmPanel;
    private JLabel titre;
    private JLabel annee;
    private JLabel pays;
    private JLabel langue;
    private JLabel duree;
    private JLabel genres;
    private JLabel realisateur;
    private JLabel scenaristes;
    private JLabel acteurs;
    private JLabel resume;
    private JLabel affiche;
    private JLabel bandesAnnonces;

    // Pour plus tard
//    private JPanel genres;
//    private JPanel scenaristes;
//    private JPanel acteurs;
//    private JPanel bandeAnnonces;


    public InfoFilmPanel() {
        this.setLayout(new BorderLayout());
        this.initFixPanel();
        this.initInfoDuFilmPanel();
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
        this.scenaristes = new JLabel();
        this.acteurs = new JLabel();
        this.resume = new JLabel();
        this.affiche = new JLabel();
        this.bandesAnnonces = new JLabel();
        this.realisateur.setForeground(Color.BLUE.darker());
        this.scenaristes.setForeground(Color.BLUE.darker());
        this.acteurs.setForeground(Color.BLUE.darker());

        this.infoDuFilmPanel = new JPanel();
        this.infoDuFilmPanel.setLayout(new GridLayout(12, 1));
        this.infoDuFilmPanel.add(this.titre);
        this.infoDuFilmPanel.add(this.annee);
        this.infoDuFilmPanel.add(this.pays);
        this.infoDuFilmPanel.add(this.langue);
        this.infoDuFilmPanel.add(this.duree);
        this.infoDuFilmPanel.add(this.genres);
        this.infoDuFilmPanel.add(this.realisateur);
        this.infoDuFilmPanel.add(this.scenaristes);
        this.infoDuFilmPanel.add(this.acteurs);
        this.infoDuFilmPanel.add(this.resume);
        this.infoDuFilmPanel.add(this.affiche);
        this.infoDuFilmPanel.add(this.bandesAnnonces);
    }

    public void setInfoDuFilm(/*Film film*/) {
        this.titre.setText("test");
        this.annee.setText("est");
        this.pays.setText("hfjjkh");
        this.langue.setText("fkhhhjj");
        this.duree.setText("ueujj");
        this.genres.setText("shhkhk");
        this.realisateur.setText("kslllllllllllllllllllllllllllllllllllllllllllllllllllhkjkh");
        this.scenaristes.setText("oppip");
        this.acteurs.setText("lbkjk (Role) ");
        this.resume.setText("kndd");
        this.affiche.setText("skhkhk");
        this.bandesAnnonces.setText("nkjk");
    }

    public void setUpPersonneMouseListener(PersonneListener parsonneListener) {
        this.realisateur.addMouseListener(parsonneListener);
        this.scenaristes.addMouseListener(parsonneListener);
        this.acteurs.addMouseListener(parsonneListener);
    }

}
