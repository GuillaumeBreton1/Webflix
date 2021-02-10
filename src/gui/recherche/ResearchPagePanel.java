package gui.recherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResearchPagePanel extends JPanel {

    private TitlePanel titlePanel;
    private ResearchBarPanel researchBarPanel;
    private ResultsPanel resultsPanel;
    private ArrayList<String> list = new ArrayList<>() {
        {
            add("allo");
            add("allo1");
            add("allo2");
            add("allo");
            add("allo1");
            add("allo2");
            add("allo");
            add("allo1");
            add("allo2");
        }
    };

    public ResearchPagePanel() {
        this.titlePanel = new TitlePanel();
        this.researchBarPanel = new ResearchBarPanel();
        this.resultsPanel = new ResultsPanel(list);
        this.setLayout(new BorderLayout(10, 10));
        this.add(this.titlePanel, BorderLayout.NORTH);
        this.add(this.researchBarPanel, BorderLayout.WEST);
        this.add(this.resultsPanel, BorderLayout.CENTER);
        this.setUpResearchButtonListener(this.resultsPanel, this);
    }

    public void setUpResearchButtonListener(ResultsPanel resultsPanel, JPanel jPanel) {
        this.researchBarPanel.getResearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsPanel.showResults();
                jPanel.validate();
                jPanel.repaint();
            }
        });
    }
}
