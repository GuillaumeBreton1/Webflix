package gui.recherche;

import gui.recherche.Listener.PersonneListener;
import gui.recherche.infoFilm.PageInfoFilmPanel;
import gui.recherche.infoPersonne.PageInfoPersonnePanel;
import gui.recherche.pageRecherche.PageDeRecherchePanel;
import gui.recherche.pageRecherche.ResultatsPanel;
import gui.recherche.Listener.RetourListener;

import javax.swing.*;
import java.awt.*;

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
        this.setUpPersonnesMouseListener();
        this.setUpRetourMouseListener();

        this.cards.add(this.pageDeRecherchePanel);
        this.cards.add(this.pageInfoFilmPanel);
        this.cards.add(this.pageInfoPersonnePanel);
        this.add(cards);

        this.setVisible(true);
    }

    public void setUpListeResultatsSelectionListener(ResultatsPanel resultatsPanel, CardLayout card, JPanel cards, PageInfoFilmPanel pageInfoFilmPanel) {
        this.pageDeRecherchePanel.getResultsPanel().getListeResultats().addListSelectionListener(e -> {
            if(e.getValueIsAdjusting() == false) {
                String filmChoisi = resultatsPanel.getListeResultats().getSelectedValue();
                resultatsPanel.setFilmChoisi(filmChoisi);
                pageInfoFilmPanel.setMovie(filmChoisi);
                card.next(cards);
            }
        });
    }

    public void setUpPersonnesMouseListener() {
        this.pageInfoFilmPanel.getInfoFilmPanel().setUpPersonnesMouseListener(
                new PersonneListener(this.pageInfoPersonnePanel, this.card, this.cards));

    }

    public void setUpRetourMouseListener() {
        this.pageInfoFilmPanel.getTitreInfoFilmPanel().setUpRetourMouseListener(
                new RetourListener(this.card, this.cards));
        this.pageInfoPersonnePanel.getTitreInfoPersonnePanel().setUpRetourMouseListener(
                new RetourListener(this.card, this.cards)
        );
    }
}
