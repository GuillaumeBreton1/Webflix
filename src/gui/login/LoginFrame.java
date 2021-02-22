package gui.login;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Webflix";
	private static final Dimension DIMENSION = new Dimension(300, 400);


	// Components 
	JLabel userLabel = new JLabel("Nom utilisateur : ");
    JLabel passwordLabel = new JLabel("Mot de passe : ");
    JTextField userField = new JTextField(); 
    JPasswordField passwordField = new JPasswordField(); 
    JButton loginButton = new JButton("Login"); 

	public LoginFrame() {
		
		setTitle(TITRE_FENETRE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(DIMENSION);
		setLayout(null);		
		//initFrame();


	}

	public void initFrame(){ 

		// On ajoute les components
		this.add(userLabel);
        this.add(passwordLabel);
        this.add(userField); 
        this.add(passwordField); 
        this.add(loginButton); 
		// On place les components
		userLabel.setBounds(30,40,120,40);		
		passwordLabel.setBounds(30,100,120,40);
		userField.setBounds(170,45,100,30); 
		passwordField.setBounds(170,105,100,30); 
		loginButton.setBounds(100,200,100,30);
		//On ajoute les actions listener 
		loginButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == loginButton){
					String utilisateur; 
					char[] motDePasse;
					utilisateur = userField.getText(); 
					motDePasse = passwordField.getPassword(); 

					System.out.print(utilisateur + " " + motDePasse.toString()); 
				}
			}

		});

	}

}