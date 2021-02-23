package gui.location;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ResultatLocationPanel extends JPanel {

    private DefaultListModel listModel;
    private InfoLocationPanel infoLocationPanel;
    private JList<String> listeResultats;
    private JScrollPane resultatsPane;


    public ResultatLocationPanel() {
        this.infoLocationPanel = new InfoLocationPanel(); 
        this.listModel = new DefaultListModel();
        this.listeResultats = new JList(listModel);
        this.resultatsPane = new JScrollPane(listeResultats);
        this.resultatsPane.setPreferredSize(new Dimension(350,550));
        this.infoLocationPanel.setPreferredSize(new Dimension(325,550));
        this.setUpListeResultatsSelectionListener(infoLocationPanel);
        this.setLayout(new BorderLayout());
        this.add(resultatsPane, BorderLayout.WEST);
        this.add(infoLocationPanel, BorderLayout.EAST);

    }

    public void montrerResultats(ArrayList<String> resultats) {

        listModel.clear();
        for(String resultat : resultats) {
            listModel.addElement(resultat);
        }
    }

    public void setUpListeResultatsSelectionListener(InfoLocationPanel infoPanel){
        this.listeResultats.addMouseListener(new MouseInputAdapter(){
            @Override
			public void mouseClicked(MouseEvent e) {
                String location = listeResultats.getSelectedValue();
                infoPanel.updateInfo(location);
			}
            
        });
    }

    public JList<String> getListeResultats() {
        return this.listeResultats;
    }

}
