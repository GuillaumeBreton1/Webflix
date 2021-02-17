package gui.recherche.infoPersonne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PageInfoPersonnePanel extends JPanel {

    private TitreInfoPersonnePanel titreInfoPersonnePanel;
    private InfoPersonnePanel infoPersonnePanel;

    public PageInfoPersonnePanel() {
        this.titreInfoPersonnePanel = new TitreInfoPersonnePanel();
        this.infoPersonnePanel = new InfoPersonnePanel();
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(new EmptyBorder(0, 40, 40, 40));
        this.add(this.titreInfoPersonnePanel, BorderLayout.NORTH);
        this.add(this.infoPersonnePanel);
    }

    public void setPersonne(String nom) {
        this.titreInfoPersonnePanel.setNomPersonne(nom);
        this.infoPersonnePanel.setInfoDeLaPersonne();
    }

    public TitreInfoPersonnePanel getTitreInfoPersonnePanel() {
        return this.titreInfoPersonnePanel;
    }

}
