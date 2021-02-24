package gui.recherche.Listener;

import gui.recherche.infoFilm.TitreInfoFilmPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LouerListener extends MouseAdapter {

    TitreInfoFilmPanel infoFilmPanel;

    public LouerListener(TitreInfoFilmPanel infoFilmPanel) {
        this.infoFilmPanel = infoFilmPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Film loué + " + this.infoFilmPanel.getFilmActuel().getId());
    }
}
