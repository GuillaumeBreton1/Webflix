package gui.recherche;

import gui.recherche.infoFilm.PageInfoFilmPanel;
import gui.recherche.infoPersonne.PageInfoPersonnePanel;
import gui.recherche.pageRecherche.PageDeRecherchePanel;
import gui.recherche.pageRecherche.ResultatsPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RechercheFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Webflix";
    private static final Dimension DIMENSION = new Dimension(700, 700);

    private CardLayout card;
    private JPanel cards;
    private PageDeRecherchePanel pageDeRecherchePanel;
    private PageInfoFilmPanel pageInfoFilmPanel;
    private PageInfoPersonnePanel pageInfoPersonnePanel;

    public RechercheFrame() {
        this.card = new CardLayout();
        this.cards = new JPanel(card);
        this.pageDeRecherchePanel = new PageDeRecherchePanel();
        this.pageInfoFilmPanel = new PageInfoFilmPanel();
        this.pageInfoPersonnePanel = new PageInfoPersonnePanel();
        setTitle(TITRE_FENETRE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(DIMENSION);
        this.setUpListeResultatsSelectionListener(this.pageDeRecherchePanel.getResultsPanel(), this.card, this.cards, this.pageInfoFilmPanel);
        this.setUpPersonnesMouseListener(this.pageInfoPersonnePanel, this.card, this.cards);
        this.cards.add(this.pageDeRecherchePanel);
        this.cards.add(this.pageInfoFilmPanel);
        this.cards.add(this.pageInfoPersonnePanel);
        this.add(cards);
        this.setVisible(true);
    }

    public void setUpListeResultatsSelectionListener(ResultatsPanel resultatsPanel, CardLayout card, JPanel cards, PageInfoFilmPanel pageInfoFilmPanel) {
        this.pageDeRecherchePanel.getResultsPanel().getListeResultats().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting() == false) {
                    String filmChoisi = resultatsPanel.getListeResultats().getSelectedValue();
                    resultatsPanel.setFilmChoisi(filmChoisi);
                    System.out.print(filmChoisi);
                    pageInfoFilmPanel.setMovie(filmChoisi);
                    card.next(cards);
                }
            }
        });
    }

    public void setUpPersonnesMouseListener(PageInfoPersonnePanel pageInfoPersonnePanel, CardLayout card, JPanel cards) {
        this.pageInfoFilmPanel.getInfoFilmPanel().getRealisateur().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String personneChoisie = ((JLabel) e.getSource()).getText();
                System.out.println(personneChoisie);
                pageInfoPersonnePanel.setPersonne(personneChoisie);
                card.next(cards);

            }
        });
    }
}
