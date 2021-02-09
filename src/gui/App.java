package gui;

import gui.recherche.ResearchBarPanel;
import gui.recherche.ResearchFrame;

public class App {

    public static void main(String[] args) {

		//LoginFrame fenetre = new LoginFrame();
		ResearchFrame rf = new ResearchFrame();
		ResearchBarPanel rp = new ResearchBarPanel();

		rf.add(rp);

	}
    
}
