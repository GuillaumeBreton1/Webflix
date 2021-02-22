package gui.recherche.pageRecherche;

import javax.swing.*;
import java.awt.*;

public class TitreRecherchePanel extends JPanel {
    private static final String TITRE_PANEL = "Rechercher un film";
    private static final String TOOLTIP_ICON_PATH = "src/gui/icon/tooltipIcon.png";

    private ImageIcon tooltipIcon;
    private JPanel tooltipPanel;
    private JPanel titrePanel;

    public TitreRecherchePanel() {
        this.setUpTooltipPanel();
        this.setUpTitrePanel();
        this.setLayout(new BorderLayout());
        this.add(this.tooltipPanel, BorderLayout.WEST);
        this.add(this.titrePanel, BorderLayout.CENTER);
    }

    public void setUpTooltipPanel() {
        this.tooltipIcon = new ImageIcon(TOOLTIP_ICON_PATH);
        JLabel tooltipLabel = new JLabel(this.tooltipIcon);
        tooltipLabel.setHorizontalAlignment(JLabel.CENTER);
        tooltipLabel.setVerticalAlignment(JLabel.CENTER);
        tooltipLabel.setToolTipText("Pour entrer plusieurs valeurs dans un champ, séparez les éléments par des virgules.");
        this.tooltipPanel = new JPanel();
        this.tooltipPanel.add(tooltipLabel);
    }

    public void setUpTitrePanel() {
        JLabel titre = new JLabel(TITRE_PANEL);
        titre.setFont(new Font(titre.getFont().getFontName(), Font.BOLD, 20));
        titre.setForeground(Color.GRAY);
        this.titrePanel = new JPanel();
        this.titrePanel.add(titre);
    }
}
