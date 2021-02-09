package gui; 

import javax.swing.JFrame;
import java.awt.Dimension;


public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Webflix";
	private static final Dimension DIMENSION = new Dimension(700, 700);


	public LoginFrame() {
		
		setVisible(true);
		setTitle(TITRE_FENETRE);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);
		setSize(DIMENSION);

	}

}