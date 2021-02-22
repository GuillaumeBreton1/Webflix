package gui.login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    
    JLabel userLabel = new JLabel("Nom utilisateur");
    JLabel passwordLabel = new JLabel("Mot de passe");
    JTextField userField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JPanel gridPanel = new JPanel();


    public LoginPanel(){ 
        
        initFrame();

    }

    public void initFrame() {
		// On ajoute les components
		this.add(userLabel);
		this.add(userField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);
        this.setLayout(null);
        this.add(this.gridPanel);
		// On place les components
		userLabel.setBounds(30,40,120,40);
		passwordLabel.setBounds(30,100,120,40);
		userField.setBounds(170,45,100,30);
		passwordField.setBounds(170,105,100,30);
		loginButton.setBounds(100,200,100,30);
		//On ajoute les actions listener

	}

	public void loginActionListener(ActionListener actionListener) {
    	loginButton.addActionListener(actionListener);
	}

	public JTextField getUserField() {
    	return this.userField;
	}

	public JPasswordField getPasswordField() {
    	return this.passwordField;
	}

	public JButton getLoginButton() {
    	return this.loginButton;
	}
    
}
