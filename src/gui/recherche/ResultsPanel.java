package gui.recherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ResultsPanel extends JPanel {

    private ArrayList<String> results;
    private JList<String> resultsList;
    private JScrollPane resultsPane;

    public ResultsPanel(ArrayList<String> results) {
        this.results = results;
        this.resultsList = new JList(results.toArray());
        this.resultsPane = new JScrollPane(resultsList);
        this.setLayout(new GridLayout(1, 1));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(resultsPane);
    }
}
