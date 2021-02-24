package gui.recherche.Listener;

import backend.hibernate.tableMapping.PersonnalitePublique;
import backend.hibernate.tableMapping.Role;
import gui.recherche.infoPersonne.PageInfoPersonnePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonneListeListener extends MouseAdapter {

    private PageInfoPersonnePanel pageInfoPersonnePanel;
    private CardLayout card;
    private JPanel cards;

    public PersonneListeListener(PageInfoPersonnePanel pageInfoPersonnePanel, CardLayout card, JPanel cards) {
        this.pageInfoPersonnePanel = pageInfoPersonnePanel;
        this.card = card;
        this.cards = cards;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        PersonnalitePublique personneChoisie = ((Role) ((JList) e.getSource()).getSelectedValue()).getActeur();
        this.pageInfoPersonnePanel.setPersonne(personneChoisie);
        this.card.next(cards);
    }
}
