package gui.recherche.Listener;

import backend.hibernate.tableMapping.PersonnalitePublique;
import gui.recherche.infoPersonne.PageInfoPersonnePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonneListener extends MouseAdapter {

    private PageInfoPersonnePanel pageInfoPersonnePanel;
    private CardLayout card;
    private JPanel cards;

    public PersonneListener(PageInfoPersonnePanel pageInfoPersonnePanel, CardLayout card, JPanel cards) {
        this.pageInfoPersonnePanel = pageInfoPersonnePanel;
        this.card = card;
        this.cards = cards;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //PersonnalitePublique personneChoisie = (PersonnalitePublique) ((JLabel) e.getSource()).getSelectedValue();
        //System.out.println(personneChoisie.getNom());
        //this.pageInfoPersonnePanel.setPersonne(personneChoisie);
        this.card.next(cards);
    }
}
