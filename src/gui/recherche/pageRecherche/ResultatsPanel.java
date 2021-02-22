package gui.recherche.pageRecherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultatsPanel extends JPanel {

    private DefaultListModel listModel;
    private JList<String> listeResultats;
    private JScrollPane resultatsPane;
    private String filmChoisi;

    public ResultatsPanel() {
        this.listModel = new DefaultListModel();
        this.listeResultats = new JList(listModel);
        this.resultatsPane = new JScrollPane(listeResultats);
        this.filmChoisi = new String();
        this.setLayout(new GridLayout(1, 1));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(resultatsPane);
    }

    public void montrerResultats(ArrayList<String> resultats) {

        listModel.clear();
        for(String resultat : resultats) {
            listModel.addElement(resultat);
        }
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
