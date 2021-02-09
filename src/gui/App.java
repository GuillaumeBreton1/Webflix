package gui;

import gui.login.LoginFrame;
import gui.login.LoginPanel;
import gui.recherche.ResearchBarPanel;
import gui.recherche.ResearchFrame;
import gui.recherche.ResultsPanel;
import gui.recherche.TitlePanel;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class App {

    public static void main(String[] args) {

        LoginPanel panel = new LoginPanel(); 
        LoginFrame fenetre = new LoginFrame();
        fenetre.add(panel); 
        fenetre.setVisible(true);
		//LoginFrame fenetre = new LoginFrame();

		ResearchFrame rf = new ResearchFrame();

	}
    
}
