package gui.recherche.Listener;

import façade.Facade;
import gui.recherche.infoFilm.TitreInfoFilmPanel;

import javax.swing.*;
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
        boolean locationValide = Facade.locationExemplaire(this.infoFilmPanel.getFilmActuel().getId());
        if (!locationValide) {
            JOptionPane.showMessageDialog(infoFilmPanel, "Location de l'exemplaire " + this.infoFilmPanel.getFilmActuel().getTitre() + " invalide",
                    "Erreur pour la location!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
