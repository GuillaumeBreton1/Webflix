package gui;

import gui.login.LoginFrame;
import gui.login.LoginPanel;
import gui.recherche.ResearchBarPanel;
import gui.recherche.ResearchFrame;

import static java.lang.Thread.sleep;

public class App {

    public static void main(String[] args) {

        LoginPanel panel = new LoginPanel(); 
        LoginFrame fenetre = new LoginFrame();
        fenetre.add(panel); 
        fenetre.setVisible(true);
		//LoginFrame fenetre = new LoginFrame();
		ResearchFrame rf = new ResearchFrame();
		ResearchBarPanel rp = new ResearchBarPanel();

		rf.add(rp);
		rf.setVisible(true);

	}
    
}
