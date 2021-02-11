package gui.recherche.pageRecherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ResultatsPanel extends JPanel {

    private ArrayList<String> resultats;
    private DefaultListModel listModel;
    private JList<String> listeResultats;
    private JScrollPane resultatsPane;
    private String filmChoisi;

    public ResultatsPanel(ArrayList<String> resultats) {
        this.resultats = resultats;
        this.listModel = new DefaultListModel();
        this.listeResultats = new JList(listModel);
        this.resultatsPane = new JScrollPane(listeResultats);
        this.filmChoisi = new String();
        this.setLayout(new GridLayout(1, 1));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(resultatsPane);
    }

    public void montrerResultats() {
        for(String result : this.resultats) {
            listModel.addElement(result);
        }
        System.out.println(this.listeResultats.getModel().getSize());
    }

    public JList<String> getListeResultats() {
        return this.listeResultats;
    }

    public String getFilmChoisi() {
        return this.filmChoisi;
    }

    public void setFilmChoisi(String filmChoisi) {
        this.filmChoisi = filmChoisi;
    }

}
