package gui.recherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ResultsPanel extends JPanel {

    private ArrayList<String> results;
    private DefaultListModel listModel;
    private JList<String> resultsList;
    private JScrollPane resultsPane;

    public ResultsPanel(ArrayList<String> results) {
        this.results = results;
        this.listModel = new DefaultListModel();
        this.resultsList = new JList(listModel);
        this.resultsPane = new JScrollPane(resultsList);
        this.setLayout(new GridLayout(1, 1));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(resultsPane);
    }

    public void showResults() {
        for(String result : this.results) {
            listModel.addElement(result);
        }
        System.out.println(this.resultsList.getModel().getSize());
    }
}
