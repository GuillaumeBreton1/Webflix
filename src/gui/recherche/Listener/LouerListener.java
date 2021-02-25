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
        int locationValide = Facade.locationExemplaire(this.infoFilmPanel.getFilmActuel().getId());
        if (locationValide == 1) {
            JOptionPane.showMessageDialog(infoFilmPanel, "Vous avez dépassé votre limite de films loués. Veuillez en retourner un!",
                    "Erreur pour la location", JOptionPane.ERROR_MESSAGE);
        }else if(locationValide == 2){
            JOptionPane.showMessageDialog(infoFilmPanel, "Le film " + this.infoFilmPanel.getFilmActuel().getTitre() + " n'a pas d'exemplaire disponible pour le moment",
                    "Erreur pour la location!", JOptionPane.ERROR_MESSAGE);
        }else if(locationValide == 0) {
            JOptionPane.showMessageDialog(infoFilmPanel, "Vous avez loué le film " + this.infoFilmPanel.getFilmActuel().getTitre() + "!",
                    "Location réussie!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
