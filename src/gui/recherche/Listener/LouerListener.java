package gui.recherche.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LouerListener extends MouseAdapter {

    public LouerListener() {}

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Film loué");
    }
}
