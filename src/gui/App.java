package gui;

import gui.login.LoginFrame;
import gui.login.LoginPanel;

public class App {

    public static void main(String[] args) {

        LoginPanel panel = new LoginPanel(); 
        LoginFrame fenetre = new LoginFrame();
        fenetre.add(panel); 
        fenetre.setVisible(true);
	}
    
}
