package gui.recherche.pageRecherche;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import backend.hibernate.tableMapping.Film;

import java.awt.*;
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

    public void displayFilms(ArrayList<Film> films) {

        listModel.clear();
        for(Film film : films) {
            String filmStr = film.getTitre() + " (" + film.getDateSortie() + " )";
            listModel.addElement(filmStr);
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
