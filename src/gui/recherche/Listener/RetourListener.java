package gui.recherche.Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RetourListener extends MouseAdapter {

    private CardLayout card;
    private JPanel cards;

    public RetourListener(CardLayout card, JPanel cards) {
        this.card = card;
        this.cards = cards;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.card.previous(cards);
    }
}
