package gui;

import backend.hibernate.tableMapping.Film;
import façade.Facade;
import gui.location.PageLocationPanel;
import gui.login.LoginPanel;
import gui.recherche.Listener.PersonneListeListener;
import gui.recherche.Listener.PersonneListener;
import gui.recherche.Listener.RetourListener;
import gui.recherche.Listener.RetourLocationListener;
import gui.recherche.infoFilm.PageInfoFilmPanel;
import gui.recherche.infoPersonne.PageInfoPersonnePanel;
import gui.recherche.pageRecherche.PageDeRecherchePanel;
import gui.recherche.pageRecherche.ResultatsPanel;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Webflix";
    private static final Dimension DIMENSION = new Dimension(700, 700);

    private CardLayout card;
    private JPanel cards;
    private LoginPanel loginPanel;
    private PageDeRecherchePanel pageDeRecherchePanel;
    private PageInfoFilmPanel pageInfoFilmPanel;
    private PageInfoPersonnePanel pageInfoPersonnePanel;
    private PageLocationPanel pageLocationPanel;

    private static Integer idFilm;

    public Frame() {
        this.card = new CardLayout();
        this.cards = new JPanel(card);
        this.loginPanel = new LoginPanel();
        this.pageDeRecherchePanel = new PageDeRecherchePanel();
        this.pageInfoFilmPanel = new PageInfoFilmPanel();
        this.pageInfoPersonnePanel = new PageInfoPersonnePanel();
        this.pageLocationPanel = new PageLocationPanel();
        this.pack();
        setTitle(TITRE_FENETRE);
        setSize(DIMENSION);
        this.setResizable(true);
        setLocationRelativeTo(null);

        this.setUpLoginActionListener(this.card, this.cards, this.loginPanel);
        this.setUpListeResultatsSelectionListener(this.pageDeRecherchePanel.getResultsPanel(), this.card, this.cards,
                this.pageInfoFilmPanel, this.pageDeRecherchePanel);
        this.setUpPersonneMouseListener();
        this.setUpRetourMouseListener();
        this.setUpLogoutActionListener(this.card, this.cards);
        this.setUpLocationActionListener(this.card, this.cards);


        this.cards.add(this.loginPanel, "login");
        this.cards.add(this.pageDeRecherchePanel, "recherche");
        this.cards.add(this.pageInfoFilmPanel, "infofilm");
        this.cards.add(this.pageInfoPersonnePanel, "infoperso");
        this.cards.add(this.pageLocationPanel, "location");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(cards);

        this.setVisible(true);
    }

    public void setUpLoginActionListener(CardLayout card, JPanel cards, LoginPanel loginPanel) {
        JButton loginButton = this.loginPanel.getLoginButton();
        JTextField userField = this.loginPanel.getUserField();
        JPasswordField passwordField = this.loginPanel.getPasswordField();
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == loginButton) {
                    String utilisateur;
                    char[] motDePasse;
                    utilisateur = userField.getText();
                    motDePasse = passwordField.getPassword();

                    boolean loginFonctionnel = Facade.login(utilisateur, motDePasse);
                    if (!loginFonctionnel) {
                        JOptionPane.showMessageDialog(loginPanel, "Mauvaise combinaison de email/mot de passe",
                                "Erreur de connexion!", JOptionPane.ERROR_MESSAGE);
                        System.out.print(utilisateur + " " + motDePasse.toString());
                    } else {
                        loginPanel.clearTextField();
                        card.next(cards);
                    }
                }
            }
        });
    }

    public void setUpLogoutActionListener(CardLayout card, JPanel cards) {

        JButton logoutButton = this.pageDeRecherchePanel.getLogoutButton();
        PageDeRecherchePanel panel = this.pageDeRecherchePanel;

        logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.first(cards);
                panel.clearListModel();
            }
        });
    }

    public void setUpLocationActionListener(CardLayout card, JPanel cards) {

        JButton locationButton = this.pageDeRecherchePanel.getLocationButton();
        locationButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    card.show(cards, "location");
            }
        });
    }

    public void setUpListeResultatsSelectionListener(ResultatsPanel resultatsPanel, CardLayout card, JPanel cards,
                                                     PageInfoFilmPanel pageInfoFilmPanel, PageDeRecherchePanel pageDeRecherchePanel) {

        this.pageDeRecherchePanel.getResultsPanel().getListeResultats().addMouseListener(new MouseInputAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int filmdID = resultatsPanel.getListeResultats().getSelectedValue().getId();
                idFilm = filmdID;
                Film film = Facade.getInfoFilms(filmdID);
                resultatsPanel.setFilmChoisi(film);
                pageInfoFilmPanel.setMovie(film);
                pageDeRecherchePanel.clearTextField();
                card.next(cards);
            }
        });
    }

    public void setUpPersonneMouseListener() {
        this.pageInfoFilmPanel.getInfoFilmPanel().setUpPersonneMouseListener(
                new PersonneListener(this.pageInfoPersonnePanel, this.card, this.cards),
                new PersonneListeListener(this.pageInfoPersonnePanel, this.card, this.cards));

    }

    public void setUpRetourMouseListener() {
        this.pageInfoFilmPanel.getTitreInfoFilmPanel().setUpRetourMouseListener(
                new RetourListener(this.card, this.cards));
        this.pageInfoPersonnePanel.getTitreInfoPersonnePanel().setUpRetourMouseListener(
                new RetourListener(this.card, this.cards));
        this.pageLocationPanel.getTitreLocationPanel().setUpRetourMouseListener(
                new RetourLocationListener(this.card, this.cards));
    }
}
