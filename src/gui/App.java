package gui;

import gui.login.LoginFrame;
import gui.login.LoginPanel;
import gui.recherche.RechercheFrame;

import static java.lang.Thread.sleep;

public class App {

    public static void main(String[] args) {

        LoginPanel panel = new LoginPanel(); 
        LoginFrame fenetre = new LoginFrame();
        fenetre.add(panel); 
        fenetre.setVisible(true);
		//LoginFrame fenetre = new LoginFrame();

		RechercheFrame rf = new RechercheFrame();

	}
    
}
